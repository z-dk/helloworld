package design.interceptor.chainofresponsibility;

import design.interceptor.Interceptor;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Method;

/**
 * <b>类 名 称</b> :  ThirdInterceptor<br/>
 * <b>类 描 述</b> :  拦截器3<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/29 14:02<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/29 14:02<br/>
 * <b>修改备注</b> :
 */
public class ThirdInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("====================拦截器3开始======================");
        return true;
    }
    
    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        
    }
    
    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("=================拦截器3结束===================");
    }
}
