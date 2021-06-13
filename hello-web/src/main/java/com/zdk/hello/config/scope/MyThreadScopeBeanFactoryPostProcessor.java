package com.zdk.hello.config.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  MyThreadScopeBeanFactoryPostProcessor<br/>
 * <b>类 描 述</b> :  注入自定义Scope到Spring容器中<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 21:04<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 21:04<br/>
 * <b>修改备注</b> :  <br/>
 * @author z_dk
 */
@Component
public class MyThreadScopeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope("myThreadScope", new MyThreadScope());
    }
}
