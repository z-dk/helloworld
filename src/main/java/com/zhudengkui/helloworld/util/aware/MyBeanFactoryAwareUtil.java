package com.zhudengkui.helloworld.util.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  MyBeanFactoryAware<br/>
 * <b>类 描 述</b> :  获取Spring容器=BeanFactoryAware<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 19:55<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 19:55<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
@Component
public class MyBeanFactoryAwareUtil implements BeanFactoryAware {
    
    private static BeanFactory beanFactory;
    
    private MyBeanFactoryAwareUtil() {}
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        MyBeanFactoryAwareUtil.beanFactory = beanFactory;
    }
    
    public static <T>T getBean(Class<T> clazz) {
        return beanFactory.getBean(clazz);
    }
    
}
