package com.zdk.hello.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * <b>类 名 称</b> :  HelloWorldEvent<br/>
 * <b>类 描 述</b> :  事件<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/10/15 16:10<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/10/15 16:10<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class HelloWorldEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public HelloWorldEvent(Object source) {
        super(source);
    }
    
}
