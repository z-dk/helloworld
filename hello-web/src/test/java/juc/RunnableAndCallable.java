package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <b>类 名 称</b> :  RunnableAndCallable<br/>
 * <b>类 描 述</b> :  test<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/16 17:18<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/16 17:18<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class RunnableAndCallable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // submit只会在获取结果时取到异常信息
        Future<Object> iii = executorService.submit(() -> {
            throw new Exception("iii");
        });
        executorService.execute(() -> {
            // 受检异常需要捕获或抛出
            throw new RuntimeException("Exception");
        });
        executorService.shutdown();
    }
    
}
