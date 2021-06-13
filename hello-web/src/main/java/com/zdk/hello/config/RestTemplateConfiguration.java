package com.zdk.hello.config;

import com.zdk.hello.filter.RestTemplateInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * <b>类 名 称</b> :  RestTemplateConfiguration<br/>
 * <b>类 描 述</b> :  restTemplate拦截器配置<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 15:54<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 15:54<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Configuration
public class RestTemplateConfiguration {
    
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(restTemplateInterceptor()));
        return restTemplate;
    }
    
    @Bean
    public RestTemplateInterceptor restTemplateInterceptor() {
        return new RestTemplateInterceptor();
    }
    
}
