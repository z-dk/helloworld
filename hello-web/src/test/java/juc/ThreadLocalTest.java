package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>类 名 称</b> :  ThreadLocalTest<br/>
 * <b>类 描 述</b> :  ThreadLocal<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/8/27 15:01<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/8/27 15:01<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class ThreadLocalTest {

    static ThreadLocal<String> threadStringLocal = new ThreadLocal<>();
    static ThreadLocal<String> stringLocal = new ThreadLocal<>();
    static ThreadLocal<Integer> threadIntegerLocal = new ThreadLocal<>();
    
    static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    
    static ExecutorService threadPool = Executors.newFixedThreadPool(1);


    public static void main(String[] args) throws InterruptedException {
        inheritableThreadLocalTest();
    }
    
    public static void inheritableThreadLocalTest() throws InterruptedException {
        inheritableThreadLocal.set("fff");
        Runnable runnable = () -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getId() + ":" + inheritableThreadLocal.get());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
        Thread.sleep(3000);
        inheritableThreadLocal.set("kkk");
        threadPool.submit(runnable);

        threadPool.shutdown();
    }
    
    public static void threadLocalTest01() {
        threadIntegerLocal.set(1234);
        stringLocal.set("string");
        threadStringLocal.set("threadString");

        System.out.println(stringLocal.get());
        stringLocal.remove();
    }
    
}
