package dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <b>类 名 称</b> :  DynamicSubject<br/>
 * <b>类 描 述</b> :  代理类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/8 18:32<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/8 18:32<br/>
 * <b>修改备注</b> :
 */
public class DynamicSubject implements InvocationHandler {
    
    private Object subject;
    
    public Object getProxy(Object target) {
        subject = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备调用方法：" + method);
        Object result = method.invoke(subject, args);
        System.out.println("方法调用结束：" + method);
        return result;
    }
}
