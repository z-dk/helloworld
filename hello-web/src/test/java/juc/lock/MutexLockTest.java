package juc.lock;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * <b>类 名 称</b> :  MutexLockTest<br/>
 * <b>类 描 述</b> :  互斥锁<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/5/7 22:45<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/5/7 22:45<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class MutexLockTest {
    
    private AtomicReference<Thread> owner = new AtomicReference<>();
    private LinkedList<Thread> waitQueue = new LinkedList<>();
    
    public static void main(String[] args) {
        
    }
    
    public void lock() {
        Thread currentThread = Thread.currentThread();
        if (!owner.compareAndSet(null, currentThread)) {
            waitQueue.add(currentThread);
            // LockSupport阻塞当前线程
            LockSupport.park();
        }
    }
    
    public void unlock() {
        if (Thread.currentThread() != owner.get()) {
            throw new RuntimeException("当前尚未获得锁，释放锁失败！");
        }
        if (waitQueue.size() > 0) {
            Thread thread = waitQueue.poll();
            owner.set(thread);
            // LockSupport释放指定线程
            LockSupport.unpark(thread);
        } else {
            owner.set(null);
        }
    }
    
}
