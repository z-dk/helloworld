package juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>类 名 称</b> :  CyclicBarrierAndCountDownLatch<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/16 21:39<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/16 21:39<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class CyclicBarrierAndCountDownLatch {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CyclicBarrierAndCountDownLatch.class);

    public static void main(String[] args) {
        // 所有线程在cyclicBarrier的wait后停下,等待最后一个wait,之后一起继续执行
        // 其通过ReentrantLock实现的
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> LOGGER.info("barrier"));
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            LOGGER.info("=== 1 ===start");
            try {
                cyclicBarrier.await();
                LOGGER.info("=== 1 ===weak up");
                Thread.sleep(3000);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            LOGGER.info("=== 1 ===end");
        });
        executorService.submit(() -> {
            LOGGER.info("=== 2 ===start");
            try {
                Thread.sleep(3000);
                cyclicBarrier.await();
                LOGGER.info("=== 2 ===weak up");
                Thread.sleep(1000);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            LOGGER.info("=== 2 ===end");
        });
        executorService.submit(() -> {
            LOGGER.info("=== 3 ===start");
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();
                LOGGER.info("=== 3 ===weak up");
                Thread.sleep(2000);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            LOGGER.info("=== 3 ===end");
        });
        executorService.shutdown();
    }
    
    
    
}
