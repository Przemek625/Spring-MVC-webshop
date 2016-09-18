package com.packt.webstore.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
/**
 * Created by Przemek on 2016-09-18.
 */
@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public EhCacheCacheManager cacheManager() {
        return new EhCacheCacheManager(ehcache().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ecmfb = new EhCacheManagerFactoryBean();
        ecmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return ecmfb;
    }
}
