package collection.queue.delayqueue;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * <b>类 名 称</b> :  DelayQueueTest<br/>
 * <b>类 描 述</b> :  延时队列delayqueue测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/10/20 20:58<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/10/20 20:58<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class DelayQueueTest {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        //初始化线程池
        BlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, 
                arrayBlockingQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        DelayQueue<DelayedTask<String>> delayTaskQueue = new DelayQueue<>();

        // 定义任务执行方法
        Function<String, String> function = param -> {
            StringBuilder builder = new StringBuilder(Thread.currentThread().getName());
            builder.append(":").append(System.currentTimeMillis()).append(">>> log >>>")
                    .append(param.getClass().getSimpleName()).append(":").append(param);
            System.out.println(builder);
            return builder.toString();
        };
        
        //模拟SIZE个延迟任务
        long now = System.currentTimeMillis();
        for (byte i = 0; i < SIZE; i++) {
            // 设置每隔3s执行一个任务
            Long runTime = now + 3000 * i;
            String taskParam = "执行第" + i + "个任务";
            delayTaskQueue.put(new DelayedTask<>(taskParam, 1, function, runTime));
        }
        delayTaskQueue.put(new DelayedTask<>("-1000任务", 1, function, now-1000));

        while (delayTaskQueue.size() != 0) {
            try {
                //从延迟队列中取值,如果没有对象过期则取到null
                DelayedTask<String> delayedTask = delayTaskQueue.poll();
                if (delayedTask != null) {
                    threadPool.execute(delayedTask);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
    
}
