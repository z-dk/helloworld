package juc.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>类 名 称</b> :  Synchronized<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/9/4 15:27<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/9/4 15:27<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Synchronized {

    static final Object lock = new Object();

    static ExecutorService executorService = Executors.newFixedThreadPool(4);


    public static void main(String[] args) throws InterruptedException {
        executorService.submit(Synchronized::syncObjTest);
        Thread.sleep(3000);
        syncObjNotifyTest();
        executorService.shutdown();
    }

    static void syncObjNotifyTest() {
        synchronized (lock) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "syncObjTest success");
            lock.notify();
            System.out.println(threadName + "syncObjTest end and notify");
        }
    }

    static void syncObjTest() {
        synchronized (lock) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "syncObjTest success");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                System.out.println(threadName + "syncObjTest InterruptedException");
                Thread.currentThread().interrupt();
            }
            System.out.println(threadName + "syncObjTest end");
        }
    }

    static void staticSyncTest() {
        Number number = new Number();

        executorService.submit(Number::getZero);
        // 调用getOne方法后,5s后释放锁后才会执行getTwo方法
        executorService.submit(number::getOne);
        executorService.submit(number::getTwo);
        executorService.submit(Number::getThree);
        executorService.submit(number::getFour);

        executorService.shutdown();
    }

    static class Number {
        
        public static synchronized void getZero() {
            System.out.println("*** zero *** start ***");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("*** zero *** end ***");
        }
        
        // 锁的是当前对象this，被锁定后，其它的线程都不能进入到当前对象的其它的synchronized方法
        public synchronized void getOne() {
            System.out.println("*** one *** start ***");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("*** one *** end ***");
        }
        public synchronized void getTwo() {
            System.out.println("two");
        }
        
        public static synchronized void getThree() {
            System.out.println("three");
        }
        
        public synchronized void getFour() {
            System.out.println("four");
            // 需等待Class的锁释放才可执行
            getThree();
        }
    }
    
}
