package app.comp.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;


@Configuration
@ComponentScan({"app.comp.service", "app.comp.repository"})
@EnableAspectJAutoProxy
@EnableCaching
public class RootConfig {


//    @Bean
//    public EhCacheManagerFactoryBean cacheFactoryBean() {
//        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
//        factoryBean.setCacheManagerName("data");
//        factoryBean.setShared(true);
//        return factoryBean;
//    }

//    @Bean
//    public CacheManager cacheManager() {
//        return new EhCacheCacheManager(Objects.requireNonNull(cacheFactoryBean().getObject()));
//    }


    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("region"),
                new ConcurrentMapCache("krp"),
                new ConcurrentMapCache("company")
        ));
        return simpleCacheManager;
    }


}
