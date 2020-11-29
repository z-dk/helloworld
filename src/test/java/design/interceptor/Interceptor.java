package design.interceptor;

import java.lang.reflect.Method;

/**
 * <b>类 名 称</b> :  Interceptor<br/>
 * <b>类 描 述</b> :  JDK动态代理实现拦截器：这里3个方法，before返回Boolean，在真实对象调用之前调用，返回true则反射真实对象方法
 *                      返回false时调用around方法，在反射真实对象方法或调用around方法之后调用after方法<br/>
 * <b>创 建 人</b> :  zdk<br/>
 * <b>创建时间</b> :  2020 11 29 11:46<br/>
 * <b>修 改 人</b> :  zdk<br/>
 * <b>修改时间</b> :  2020 11 29 11:46<br/>
 * <b>修改备注</b> :  
 */
public interface Interceptor {
    
    /**
     * 方法描述: 拦截器接口
     * @param proxy ff
     * @return boolean
     * @author zdk
     * <br/><b>创建时间:</b>2020/11/29 12:31
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/11/29 12:31
     * @since  1.0.0
     */
    public boolean before(Object proxy, Object target, Method method, Object[] args);
    
    /**
     * 方法描述: 拦截器接口
     * @param proxy
	 * @param target
	 * @param method
	 * @param args
     * @return void
     * @author zdk
     * <br/><b>创建时间:</b>2020/11/29 12:36
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/11/29 12:36
     * @since  1.0.0
     */
    public void around(Object proxy, Object target, Method method, Object[] args);
    
    public void after(Object proxy, Object target, Method method, Object[] args);
    
}
