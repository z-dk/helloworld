package juc.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>类 名 称</b> :  Lock<br/>
 * <b>类 描 述</b> :  reentrantLock测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/16 14:57<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/16 14:57<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class MyLock {
    
    ReentrantLock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    Thread thread = null;

    public static void main(String[] args) {
        MyLock mine = new MyLock();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(mine::lockTest);
        executorService.execute(() -> {
            try {
                mine.interruptLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mine.interrupt();
        });
        executorService.shutdown();
    }
    
    public void interrupt() {
        if (Thread.interrupted()) {
            System.out.println(Thread.currentThread().getId() + "我interrupted了");
        } else {
            System.out.println(Thread.currentThread().getId() + "我没有interrupted");
        }
    }
    
    public void lockTest() {
        lock.lock();
        try {
            thread = Thread.currentThread();
            condition.await();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getId() + "我吞了InterruptException");
        }
        System.out.println(Thread.currentThread().getId() + "我醒了");
        lock.unlock();
    }
    
    public void interruptLock() throws InterruptedException {
        lock.lock();
        if (thread != null) {
            thread.interrupt();
        }
        // 在未释放锁之前,其他线程不会有响应
        lock.unlock();
    }
    
}
