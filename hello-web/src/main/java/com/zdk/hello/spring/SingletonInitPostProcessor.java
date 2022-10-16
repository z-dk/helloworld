package com.zdk.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  SingletonInitPostProcessor<br/>
 * <b>类 描 述</b> :  单例bean初始化的后置处理(非懒加载的bean)<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/10/15 15:56<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/10/15 15:56<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Component
public class SingletonInitPostProcessor implements SmartInitializingSingleton {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SingletonInitPostProcessor.class);
    
    @Override
    public void afterSingletonsInstantiated() {
        LOGGER.info("all singleton bean is initialized finished");
    }
}
