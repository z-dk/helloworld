package com.zdk.hello.config.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * <b>类 名 称</b> :  MyScope<br/>
 * <b>类 描 述</b> :  自定义Scope，线程作用域<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 20:51<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 20:51<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
public class MyThreadScope implements Scope {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MyThreadScope.class);
    
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();
    
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        Object value = THREAD_LOCAL.get();
        if (value != null) {
            LOGGER.info("get value from Thread:{}", Thread.currentThread().getId());
            return value;
        }
        Object ob = objectFactory.getObject();
        THREAD_LOCAL.set(ob);
        return ob;
    }
    
    @Override
    public Object remove(String s) {
        THREAD_LOCAL.remove();
        return null;
    }
    
    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {
        
    }
    
    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }
    
    @Override
    public String getConversationId() {
        return null;
    }
}
