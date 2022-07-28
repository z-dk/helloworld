package juc.forkjoinpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;

/**
 * <b>类 名 称</b> :  ForkAndJoinTest<br/>
 * <b>类 描 述</b> :  forkjoin<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/28 20:43<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/28 20:43<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class ForkAndJoinTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ForkAndJoinTest.class);

    public static void main(String[] args) {
        fibonacciTest(10);
        getArrayMaxVal(new int[]{234,23,123,6,77,8456,85,90});
    }

    /**
     * 计算斐波那契数列
     * @param n 值
     */
    private static void fibonacciTest(int n) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Integer rs = forkJoinPool.invoke(new Fibonacci(n));
        System.out.println(forkJoinPool.getActiveThreadCount());
        LOGGER.info("斐波那契数列:f({})={}", n, rs);
    }
    
    /**
     * 获取数组的最大值
     * @param array 值
     */
    private static void getArrayMaxVal(int [] array) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Integer rs = forkJoinPool.invoke(new MyTask(0, array.length - 1, array));
        System.out.println(forkJoinPool.getActiveThreadCount());
        LOGGER.info("最大值:{}", rs);
    }
    
    
    
}
