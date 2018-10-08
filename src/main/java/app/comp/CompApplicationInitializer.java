package app.comp;

import app.comp.config.RootConfig;
import app.comp.config.SecurityConfig;
import app.comp.config.WebConfig;
import app.comp.config.persistenceConfig.DataPersistenceConfig;
import app.comp.config.persistenceConfig.SystemPersistenceConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CompApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, DataPersistenceConfig.class, SystemPersistenceConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
