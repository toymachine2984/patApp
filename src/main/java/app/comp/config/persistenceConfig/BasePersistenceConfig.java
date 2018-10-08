package app.comp.config.persistenceConfig;


import app.comp.util.AuditorAwareImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;


@Component
@PropertySource({"classpath:db.properties"})
public class BasePersistenceConfig {

    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource, String... packagesToScan) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan(packagesToScan);
        localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties());
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }


    private Properties jpaProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));


                /*AUDIT PROPERTY*/
                setProperty("org.hibernate.envers.audit_table_suffix", "_AUDIT");
                setProperty("org.hibernate.envers.default_catalog", "audit");
                setProperty("org.hibernate.envers.audit_strategy", "org.hibernate.envers.strategy.ValidityAuditStrategy");
                setProperty("org.hibernate.envers.audit_strategy_validity_store_revend_timestamp", "true");
                setProperty("org.hibernate.envers.revision_field_name", "REV");
                setProperty("org.hibernate.envers.revision_type_field_name", "REVTYPE");
                setProperty("org.hibernate.envers.audit_strategy_validity_end_rev_field_name", "REVEND");
                setProperty("org.hibernate.envers.audit_strategy_validity_revend_timestamp_field_name", "REVEND_TSTMP");


                setProperty("hibernate.hbm2ddl.auto", "update"); // fixme off in release version
                setProperty("hibernate.max_fetch_depth", env.getProperty("hibernate.max_fetch_depth"));
                setProperty("hibernate.jdbc.fetch_size", env.getProperty("hibernate.jdbc.fetch_size"));
                setProperty("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
            }
        };
    }
}

