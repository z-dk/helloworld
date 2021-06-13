package com.zdk.hello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <b>类 名 称</b> :  ThreadPoolConfig<br/>
 * <b>类 描 述</b> :  Spring异步专用线程池配置<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 16:50<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 16:50<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Configuration
public class ThreadPoolConfig {
    
    @Value("${thread.pool.corePoolSize:5}")
    private int corePoolSize;
    
    @Value("${thread.pool.maxPoolSize:20}")
    private int maxPoolSize;
    
    @Value("${thread.pool.queueCapacity:200}")
    private int queueCapacity;
    
    @Value("${thread.pool.keepAliveSeconds:60}")
    private int keepAliveSeconds;
    
    @Value("${thread.pool.threadNamePrefix:ASYNC_}")
    private String threadNamePrefix;
    
    @Bean
    public Executor messageExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
