package app.comp.config.persistenceConfig;

import app.comp.util.AuditorAwareImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableConfigurationProperties
@EnableJpaRepositories(
        entityManagerFactoryRef = "systemEntityManagerFactory",
        transactionManagerRef = "systemEntityManager",
        basePackages = {"app.comp.repository.systemRepository"})
public class SystemPersistenceConfig extends BasePersistenceConfig {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "system.datasource")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "systemEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        return getEntityManagerFactory(firstDataSource(), "app.comp.entity.system");
    }

    @Primary
    @Bean(name = "systemEntityManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

}
