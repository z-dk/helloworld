package juc.reentrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * 多线程按升序打印数字=ReentrantLock实现方式
 * @author zdk
 */
public class SixteenPrint {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SixteenPrint.class);
    
    static ReentrantLock lock = new ReentrantLock(false);
    static Condition condition = lock.newCondition();
    static volatile int intFlag = 0;
    
    public static void print(int n) {
        lock.lock();
        switch (n) {
            case 0:
                while (intFlag != 0) {
                    try {
                        LOGGER.info("0 is waiting");
                        condition.await();
                        LOGGER.info("0 is continue");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(n);
                condition.signalAll();
                intFlag = 1;
                break;
            case 1:
                while (intFlag != 1) {
                    try {
                        LOGGER.info("1 is waiting");
                        condition.await();
                        LOGGER.info("1 is continue");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(n);
                condition.signalAll();
                intFlag = 2;
                break;
            case 2:
                while (intFlag != 2) {
                    try {
                        LOGGER.info("2 is waiting");
                        condition.await();
                        LOGGER.info("2 is continue");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(n);
                condition.signalAll();
                intFlag = 3;
                break;
            case 3:
                while (intFlag != 3) {
                    try {
                        LOGGER.info("3 is waiting");
                        condition.await();
                        LOGGER.info("3 is continue");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(n);
                condition.signalAll();
                intFlag = 0;
                break;
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        AtomicInteger integer = new AtomicInteger(3);
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                print(integer.getAndAdd(-1));
            });
        }
        executorService.shutdown();
    }
    
}
