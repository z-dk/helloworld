package com.zhudengkui.helloworld.config;

import com.zhudengkui.helloworld.filter.AuthInterceptor;
import com.zhudengkui.helloworld.filter.LogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>类 名 称</b> :  WebConfig<br/>
 * <b>类 描 述</b> :  spring web配置<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 9:45<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 9:45<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor());
    }
    
    @Bean
    public AuthInterceptor getAuthInterception() {
        return new AuthInterceptor();
    }
    
    @Bean
    public LogFilter getLogFilter() {
        return new LogFilter();
    }
    
    static class DateConverter implements Converter<String,Date> {
    
        @Override
        public Date convert(String source) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
    
}
