package thread;

import java.util.concurrent.CountDownLatch;

/**
 * <b>类 名 称</b> :  LockTest<br/>
 * <b>类 描 述</b> :  锁<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/9/13 8:42<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/9/13 8:42<br/>
 * <b>修改备注</b> :
 */
public class LockTest {
    
    public static void main(String[] args) {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void test() throws InterruptedException {
        Thread thread = Thread.currentThread();
        
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        integerThreadLocal.set(4);
        integerThreadLocal.set(6);
        System.out.println(integerThreadLocal.get());
        
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("111");
        System.out.println(stringThreadLocal.get());
    
        CountDownLatch latch = new CountDownLatch(3);
        latch.await();
    }
}
