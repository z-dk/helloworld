package jdk.schedule;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <b>类 名 称</b> :  TimerTest<br/>
 * <b>类 描 述</b> :  Timer测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/10/21 21:36<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/10/21 21:36<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class TimerTest {

    public static void main(String[] args) {
        
    }
    
    public static void test() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(13);
            }
        }, 3000L);
    }
    
    public static void threadPool() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(5);
        service.schedule(() -> System.out.println("123"), 3000L, TimeUnit.MILLISECONDS);
    }
    
}
