package design.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <b>类 名 称</b> :  InterceptorJdkProxy<br/>
 * <b>类 描 述</b> :  拦截器JDK代理类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/29 12:41<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/29 12:41<br/>
 * <b>修改备注</b> :
 */
public class InterceptorJdkProxy implements InvocationHandler {
    
    /**
     * 真实对象
     */
    private Object target;
    
    /**
     * 拦截器全限定名
     */
    private Class<?> interceptorClass;
    
    public InterceptorJdkProxy(Object target, Class<?> interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }
    
    public static Object bind(Object target, Class<?> interceptorClass) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), 
                new InterceptorJdkProxy(target, interceptorClass));
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            return method.invoke(target,args);
        }
        Object result = null;
        Interceptor interceptor = (Interceptor) interceptorClass.newInstance();
        if (interceptor.before(proxy, target, method, args)) {
            result = method.invoke(target, args);
        } else {
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);
        return result;
    }
}
