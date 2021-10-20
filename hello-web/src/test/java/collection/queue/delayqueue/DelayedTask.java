package collection.queue.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * <b>类 名 称</b> :  DelayedTask<br/>
 * <b>类 描 述</b> :  延时任务<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/10/20 21:26<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/10/20 21:26<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class DelayedTask<T> implements Delayed, Runnable {

    /**
     * 任务参数
     */
    private final T taskParam;

    /**
     * 任务类型
     */
    private final Integer type;

    /**
     * 任务函数
     */
    private final Function<T, String> function;

    /**
     * 任务执行时刻,时间戳
     */
    private final Long runTime;

    public DelayedTask(T taskParam, Integer type, Function<T, String> function, Long runTime) {
        this.taskParam = taskParam;
        this.type = type;
        this.function = function;
        this.runTime = runTime;
    }

    @Override
    public void run() {
        if (taskParam != null) {
            function.apply(taskParam);
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.runTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        // 以执行时间戳值的大小比较,越小优先级越高
        if (o instanceof DelayedTask) {
            return this.runTime.compareTo(((DelayedTask<?>) o).runTime);
        } else {
            return -1;
        }
    }

    public T getTaskParam() {
        return taskParam;
    }

    public Integer getType() {
        return type;
    }

    public Function<T, String> getFunction() {
        return function;
    }

    public Long getRunTime() {
        return runTime;
    }
}
