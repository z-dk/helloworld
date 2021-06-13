package com.zdk.hello.util.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  MyApplicationContextAwareUtil<br/>
 * <b>类 描 述</b> :  获取spring容器<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 20:01<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 20:01<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
@Component
public class MyApplicationContextAwareUtil implements ApplicationContextAware {
    
    private static ApplicationContext applicationContext;
    
    private MyApplicationContextAwareUtil() {}
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyApplicationContextAwareUtil.applicationContext = applicationContext;
    }
    
    public static <T>T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    
}
