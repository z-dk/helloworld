package design.interceptor.chainofresponsibility;

import design.interceptor.InterceptorDemo;
import design.interceptor.InterceptorJdkProxy;

/**
 * <b>类 名 称</b> :  ChainOfResponsibilityPatternDemo<br/>
 * <b>类 描 述</b> :  责任链模式<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/29 13:55<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/29 13:55<br/>
 * <b>修改备注</b> :
 */
public class ChainOfResponsibilityPatternDemo {
    
    /**
     * 方法描述: 责任链模式仅仅是针对一条流水线进行处理而已，实现方式多种多样，这里使用多个拦截器处理
     * @param args
     * @return void
     * @author zdk
     * <br/><b>创建时间:</b>2020/11/29 13:56
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/11/29 13:56
     * @since  1.0.0
     */
    public static void main(String[] args) {
        InterceptorDemo.HelloWorld proxy1 = (InterceptorDemo.HelloWorld) InterceptorJdkProxy.bind(new InterceptorDemo.HelloWorldImpl(), FirstInterceptor.class);
        InterceptorDemo.HelloWorld proxy2 = (InterceptorDemo.HelloWorld) InterceptorJdkProxy.bind(proxy1, SecondInterceptor.class);
        InterceptorDemo.HelloWorld proxy3 = (InterceptorDemo.HelloWorld) InterceptorJdkProxy.bind(proxy2, ThirdInterceptor.class);
        System.out.println("main:"+proxy3.sayHi());
    }
    
}
