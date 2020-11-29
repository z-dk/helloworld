package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

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
            countDownLatchTest();
        } catch (InterruptedException | BrokenBarrierException e) {
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
    }
    
    public static void countDownLatchTest() throws InterruptedException, BrokenBarrierException {
        AtomicReference<CountDownLatch> latch = new AtomicReference<>(new CountDownLatch(2));
        
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            int i = 1;
            while (true) {
                System.out.println(i);
                latch.get().countDown();
                latch.get().await();
                latch.set(new CountDownLatch(1));
                i++;
            }
        });
        executorService.submit(() -> {
            Character i = 'A';
            while (true) {
                latch.get().countDown();
                latch.get().await();
                System.out.println(i);
                latch.set(new CountDownLatch(1));
                i++;
            }
        });
    }
}
