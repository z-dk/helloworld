package juc.lock.wait;

/**
 * <b>类 名 称</b> :  Product<br/>
 * <b>类 描 述</b> :  产品<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/9/4 11:07<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/9/4 11:07<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Product {

    //库存共享数据 存在安全问题
    private int product = 0;

    //进货
    public synchronized void get() {
        while (product >= 1) {
            System.out.println("产品已满，无法添加");
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "店员进货1个产品 库存为" + ++product);
    }

    //卖货
    public synchronized void sale() {
        // 这里应使用while而非if:避免虚假唤醒导致的库存超卖问题,即:多个消费者同时wait时突然库存+1,导致多个消费者同时消费使库存<0
        while (product <= 0) {
            System.out.println("产品缺货，无法售卖");
            try {
                // wait方法应总是在循环中
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println(Thread.currentThread().getName() + "店员销售1个产品 库存为" + --product);
        this.notifyAll();
    }
    
}
