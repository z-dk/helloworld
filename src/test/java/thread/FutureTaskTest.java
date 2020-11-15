package thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * <b>类 名 称</b> :  FutureTaskTest<br/>
 * <b>类 描 述</b> :  future测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/15 20:37<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/15 20:37<br/>
 * <b>修改备注</b> :
 */
public class FutureTaskTest {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        executor.submit(() -> System.out.println("hello world!"));
    
        FutureTask<Integer> futureTask = new FutureTask<>(() -> ThreadLocalRandom.current().nextInt(10));
        executor.submit(futureTask);
        Integer result = futureTask.get(5, TimeUnit.SECONDS);
        System.out.println(result);
    
        // Timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask");
            }
        }, 5);
        
        executor.shutdown();
    }
    
}
