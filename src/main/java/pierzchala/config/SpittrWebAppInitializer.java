package pierzchala.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     *
     * Gdy serwlet dystrybutora DispatcherServlet rozpoczyna działanie, tworzy kontekst
     * aplikacji Springa i wypełnia go komponentami zadeklarowanymi we wskazanych klasach
     * lub plikach konfiguracyjnych. Na listingu 5.1 wykorzystaliśmy metodę getServletConfig
     *  Classes() , aby przy pomocy serwletu dystrybutora załadować do kontekstu aplikacji
     * komponenty zdefiniowane w klasie konfiguracji WebConfig (używając konfiguracji Java-
     * Config).
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() { // klasa kongiguracyjna
        return new Class<?>[]{WebConfig.class};
    }


    /**
     * Pierwsza metoda, getServletMappings() , zwraca tablicę złożoną z jednej lub większej
     * liczby ścieżek, którym przypisano odwzorowanie serwletu dystrybutora. W naszym
     * przypadku jest to / , co oznacza, że jest to domyślny serwlet w naszej aplikacji. Obsłuży
     * on wszystkie żądania przychodzące do aplikacji.
     */
    @Override
    protected String[] getServletMappings() { // serwlet dystrybutora na /
        return new String[]{"/"};
    }
}
