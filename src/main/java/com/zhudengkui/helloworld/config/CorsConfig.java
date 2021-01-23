package com.zhudengkui.helloworld.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <b>类 名 称</b> :  CorsConfig<br/>
 * <b>类 描 述</b> :  Cors解决跨域请求问题<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 10:24<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 10:24<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                // 是否允许发送Cookie
                .allowCredentials(true)
                // 本次预检请求的有效期，单位为秒
                .maxAge(3600)
                .allowedHeaders("*");
    }
    
}
