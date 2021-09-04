package juc.lock.wait;

/**
 * <b>类 名 称</b> :  Consumer<br/>
 * <b>类 描 述</b> :  消费者<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/9/4 11:05<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/9/4 11:05<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Consumer implements Runnable{

    private final Product product;
    public Consumer(Product product) {
        this.product = product;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            product.sale();
        }
    }
}
