package pierzchala.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"pierzchala"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
    /**
     * Jedynym istotnym elementem w klasie RootConfig jest adnotacja @ComponentScan , którą
     * ta klasa została opatrzona. Na łamach tej książki pojawi się mnóstwo okazji, aby zamie-
     * ścić w tej klasie różne komponenty niezwiązane z ustawieniami internetowymi.
     */
}
