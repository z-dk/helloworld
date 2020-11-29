package design.interceptor;


/**
 * <b>类 名 称</b> :  InterceptorDemo<br/>
 * <b>类 描 述</b> :  拦截器测试代码<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/29 11:42<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/29 11:42<br/>
 * <b>修改备注</b> :
 */
public class InterceptorDemo {
    
    /**
     * 方法描述: Interceptor为拦截器接口，可对应多个拦截器的实现，使用jdk动态代理的方式对需要拦截的方法进行拦截
     * 拦截器接口及其对应实现算是对jak动态代理拿到的代理方法、参数的处理而已，本质还是动态代理，只是利用多态灵活配置自定义拦截器而已
     * @param args
     * @return void
     * @author zdk
     * <br/><b>创建时间:</b>2020/11/29 13:42
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/11/29 13:42
     * @since  1.0.0
     */
    public static void main(String[] args) {
        HelloWorld helloWorld = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), MyInterceptor.class);
        System.out.println("main:"+helloWorld.sayHi());
    }
    
    public static class HelloWorldImpl implements HelloWorld {
        public String sayHi() {
            System.out.println("Hello world!");
            return "Hello world!";
        }
    }
    
    public interface HelloWorld {
        public String sayHi();
    }
    
}
