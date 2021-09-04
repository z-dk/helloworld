package juc.lock.condition;

import juc.lock.wait.Product;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>类 名 称</b> :  ProductLock<br/>
 * <b>类 描 述</b> :  Product的另一种加锁的实现,使用ReentrantLock+Condition替代synchronized<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/9/4 11:52<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/9/4 11:52<br/>
 * <b>修改备注</b> :  <br/>
 * @see juc.lock.wait.Product
 * @author zdk
 */
public class ProductLock implements Product {
    
    private int product = 0;
    
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    //进货
    @Override
    public void get() {
        lock.lock();
        try {
            while (product >= 1) {
                System.out.println("产品已满，无法添加");
                try {
                    condition.await();
                } catch (InterruptedException ignored) {
                }
            }
            condition.signalAll();
            System.out.println(Thread.currentThread().getName() + "店员进货1个产品 库存为" + ++product);
        } finally {
            lock.unlock();
        }
    }

    //卖货
    @Override
    public synchronized void sale() {
        lock.lock();
        while (product <= 0) {
            System.out.println("产品缺货，无法售卖");
            try {
                condition.await();
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println(Thread.currentThread().getName() + "店员销售1个产品 库存为" + --product);
        condition.signalAll();
    }
}
