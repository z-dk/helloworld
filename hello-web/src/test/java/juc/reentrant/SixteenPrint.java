package juc.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
    
    static ReentrantLock lock = new ReentrantLock(false);
    static Condition condition0 = lock.newCondition();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    static Condition condition3 = lock.newCondition();
    static volatile boolean flag = false;
    
    public static void print(int n) {
        switch (n) {
            case 0:
                lock.lock();
                System.out.println(n);
                condition1.signal();
                flag = true;
                lock.unlock();
                break;
            case 1:
                lock.lock();
                try {
                    while (!flag) {
                        condition1.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(n);
                condition2.signal();
                lock.unlock();
                break;
            case 2:
                lock.lock();
                try {
                    while (!flag) {
                        condition2.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(n);
                condition3.signal();
                lock.unlock();
                break;
            case 3:
                lock.lock();
                try {
                    while (!flag) {
                        condition3.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(n);
                condition0.signal();
                lock.unlock();
                break;
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        AtomicInteger integer = new AtomicInteger(3);
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                print(integer.getAndAdd(-1));
            });
        }
        executorService.shutdown();
    }
    
}
