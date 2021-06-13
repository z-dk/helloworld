package com.zdk.hello.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * <b>类 名 称</b> :  CacheConfig<br/>
 * <b>类 描 述</b> :  Spring缓存配置<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 17:30<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 17:30<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Configuration
@EnableCaching
public class CacheConfig {
    
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine<Object, Object> objectCaffeine = Caffeine.newBuilder()
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .maximumSize(1000);
        cacheManager.setCaffeine(objectCaffeine);
        return cacheManager;
    }
    
}
