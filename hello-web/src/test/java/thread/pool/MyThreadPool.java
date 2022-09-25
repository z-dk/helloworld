package thread.pool;

import java.util.concurrent.*;

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

    /**
     * 1.线程池中的线程执行中遇到异常会怎样?
     * 2.execute与submit执行的区别?
     */
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,20, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        runtimeException();
        executor.shutdown();
    }
    
    public static void runtimeException() throws ExecutionException, InterruptedException {
        // execute执行的异常会正常打印
        executor.execute(() -> {
            throw new NullPointerException("呀,空了耶^_^");
        });
        
        // submit提交的任务只有在获取返回值时才会正常获取到异常信息
        Future<?> submit = executor.submit(() -> {
            //throw new NullPointerException("submit a NPE");
            System.out.println("submit is complete");
        });
        System.out.println(submit.get());
    }
    
}
