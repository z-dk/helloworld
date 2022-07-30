package juc.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>类 名 称</b> :  SixteenPrint<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/30 10:58<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/30 10:58<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class SixteenPrint {
    
    static Semaphore semaphore0 = new Semaphore(1);
    static Semaphore semaphore1 = new Semaphore(0);
    static Semaphore semaphore2 = new Semaphore(0);
    static Semaphore semaphore3 = new Semaphore(0);
    
    public static void print(int n) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            switch (n) {
                case 0:
                    semaphore0.acquire();
                    System.out.println(n);
                    semaphore1.release();
                    break;
                case 1:
                    semaphore1.acquire();
                    System.out.println(n);
                    semaphore2.release();
                    break;
                case 2:
                    semaphore2.acquire();
                    System.out.println(n);
                    semaphore3.release();
                    break;
                case 3:
                    semaphore3.acquire();
                    System.out.println(n);
                    semaphore0.release();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        AtomicInteger integer = new AtomicInteger(3);
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                try {
                    print(integer.getAndAdd(-1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
    
}
