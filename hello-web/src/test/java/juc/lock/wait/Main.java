package juc.lock.wait;

import juc.lock.condition.ProductLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>类 名 称</b> :  Main<br/>
 * <b>类 描 述</b> :  主程序<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/9/4 11:11<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/9/4 11:11<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Main {

    public static void main(String[] args) {
        Product product = productLock();
        
        @SuppressWarnings("unused")
        Product productSync = productSync();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Producer(product));
        executorService.submit(new Consumer(product));
        executorService.shutdown();
    }
    
    public static Product productSync() {
        return new ProductSync();
    }
    
    public static Product productLock() {
        return new ProductLock();
    }
    
}
