package app.comp.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Objects;


@Configuration
@ComponentScan({"app.comp.service", "app.comp.repository"})
@EnableAspectJAutoProxy
@EnableCaching
public class RootConfig {


    @Bean
    public EhCacheManagerFactoryBean cacheFactoryBean() {
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setCacheManagerName("data");
        factoryBean.setShared(true);
        return factoryBean;
    }

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(Objects.requireNonNull(cacheFactoryBean().getObject()));
    }





//
//        ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
//        cacheFactoryBean.setName("company");
//        return cacheFactoryBean;

//
//    @Bean
//    public CacheManager cacheManager() {
//        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
//        simpleCacheManager.setCaches(Arrays.asList(
//                new ConcurrentMapCache("region"),
//                new ConcurrentMapCache("krp"),
//                new ConcurrentMapCache("company")
//        ));
//        return simpleCacheManager;
//    }

//    @Bean
//    public RegionSerializer regionSerializer() {
//        return new RegionSerializer();
//    }
//


//    @Bean
//    public SimpleCacheManager cacheManager() {
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        List<Cache> caches = new ArrayList<>();
//        caches.add(cacheFactoryBean().getObject());
//        caches.add(cacheManager2().getCache("region"));
//        cacheManager.setCaches(caches);
//        return cacheManager;
//    }


//    @Bean
//    public Workbook getWorkbook() {
//        return new XSSFWorkbook();
//    }
//
//
//    @Bean
//    public Logger getLogger() {
//        return new Logger();
//    }

}
