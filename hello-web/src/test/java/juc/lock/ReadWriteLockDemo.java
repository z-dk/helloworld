package juc.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <b>类 名 称</b> :  ReadWriteLock<br/>
 * <b>类 描 述</b> :  read/write<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/9/4 14:59<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/9/4 14:59<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        
        ReadWriteNum num = new ReadWriteNum();
        executorService.submit(() -> num.set(new Random().nextInt(1000)));
        for (int i = 0; i < 100; i++) {
            executorService.submit(num::get);
        }
    }
    
    static class ReadWriteNum {
        private int number = 0;
        
        // 读写锁    读和写之间不互斥  写和写之间互斥
        private final ReadWriteLock lock = new ReentrantReadWriteLock();

        //读
        public int get() {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "读:" + number);
                return number;
            } finally {
                lock.readLock().unlock();
            }
        }

        //写
        public void set(int number) {
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "写:" + number);
                this.number = number;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
    
}
