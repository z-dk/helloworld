package com.zdk.hello.spring;

import com.zdk.hello.spring.event.HelloWorldEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  HelloWorldListener<br/>
 * <b>类 描 述</b> :  事件监听<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/10/15 16:06<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/10/15 16:06<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Component
public class HelloWorldListener implements ApplicationListener<HelloWorldEvent> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldListener.class);

    @Override
    public void onApplicationEvent(HelloWorldEvent event) {
        LOGGER.info("事件[{}]在此时[{}]发生", event.getSource(), event.getTimestamp());
    }
}
