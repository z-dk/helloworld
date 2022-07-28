package juc.forkjoinpool;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * <b>类 名 称</b> :  MyTask<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/28 20:59<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/28 20:59<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
class MyTask extends RecursiveTask<Integer> {

    int start;
    int end;
    int[] targetArray;

    public MyTask(int start, int end, int[] targetArray) {
        this.start = start;
        this.end = end;
        this.targetArray = targetArray;
    }

    @Override
    protected Integer compute() {
        if (this.end - this.start < 10) {
            return Arrays.stream(this.targetArray, this.start ,this.end + 1).max().orElse(0);
        }else{
            int newBegin = this.start + 10;
            MyTask newTask = new MyTask(newBegin, this.end, this.targetArray);
            MyTask threadTask = new MyTask(this.start, newBegin - 1, this.targetArray);
            //任务分叉
            threadTask.fork();
            Integer compute = newTask.compute();
            //任务收集
            Integer join = threadTask.join();
            if (targetArray[compute] > targetArray[join]) {
                return compute;
            } else {
                return join;
            }
        }
    }
}
