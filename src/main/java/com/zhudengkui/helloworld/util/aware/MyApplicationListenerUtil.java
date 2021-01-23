package com.zhudengkui.helloworld.util.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  MyApplicationListenerUtil<br/>
 * <b>类 描 述</b> :  获取spring容器<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 20:04<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 20:04<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
@Component
public class MyApplicationListenerUtil implements ApplicationListener<ContextRefreshedEvent> {
    
    private static ApplicationContext applicationContext;
    
    private MyApplicationListenerUtil() {}
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        applicationContext = event.getApplicationContext();
    }
    
    public static <T>T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    
}
