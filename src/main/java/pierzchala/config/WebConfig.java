package pierzchala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
@EnableWebMvc
@ComponentScan("pierzchala")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Następnie dodajemy komponent ViewResolver . Mówiąc dokładnie, jest to obiekt klasy
     * InternalResourceViewResolver . W rozdziale 6. powiem więcej na temat producentów
     * widoku. W tej chwili musisz wiedzieć tylko tyle, że producent widoku służy do wyszu-
     * kiwania plików JSP poprzez dodawanie prefiksu i sufiksu do nazw widoków (na przy-
     * kład widok o nazwie home zostanie odczytany jako /WEB-INF/views/home.jsp).
     * @return
     */

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        /**
         * Aby producent InternalResourceViewResolver zamiast widoków InternalResourceView
         * produkował widoki JstlView , wystarczy ustawić wartość właściwości viewClass :
         */
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        /**
         * Niezależnie od wybranego sposobu konfiguracji, dzięki powyższym ustawieniom do
         * znaczników formatowania i komunikatów przekazane zostaną ustawienia Locale i źródła
         * komunikatów skonfigurowane w Springu.
         */
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    public void configureDefaultServletHandling (
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx =
                new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet =
                container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
