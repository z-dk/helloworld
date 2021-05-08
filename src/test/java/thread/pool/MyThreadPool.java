package thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <b>类 名 称</b> :  MyThreadPoll<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/3/6 16:32<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/3/6 16:32<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class MyThreadPool {
    
    public static void main(String[] args) {
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,20, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.execute(() -> System.out.println("a runnable"));
        executor.submit(() -> System.out.println("runnable or callable"));
        
    }
    
}
