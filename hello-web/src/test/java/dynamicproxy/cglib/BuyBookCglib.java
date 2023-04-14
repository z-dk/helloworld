package dynamicproxy.cglib;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <b>类 名 称</b> :  BuyBookCglib<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/8 20:01<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/8 20:01<br/>
 * <b>修改备注</b> :
 */
public class BuyBookCglib implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyBookCglib.class);
    
    static Library getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Library.class);
        enhancer.setCallback(new BuyBookCglib());
        return (Library) enhancer.create();
    }
    
    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        LOGGER.info("调用前,参数:{}", JSON.toJSONString(params));
        Object result = methodProxy.invokeSuper(o, params);
        LOGGER.info("执行结果:{}", JSON.toJSONString(result));
        return result;
    }
}
