package design.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * <b>类 名 称</b> :  MyInterceptor<br/>
 * <b>类 描 述</b> :  拦截器<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/29 12:06<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/29 12:06<br/>
 * <b>修改备注</b> :
 */
public class MyInterceptor implements Interceptor {
    private final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        logger.info("反射方法前逻辑");
        return false;
    }
    
    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        logger.info("取待了被代理对象的方法");
    }
    
    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        logger.info("反射方法后的逻辑");
    }
}
