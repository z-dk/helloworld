package juc.forkjoinpool;

import java.util.concurrent.RecursiveTask;

/**
 * <b>类 名 称</b> :  Fibonacci<br/>
 * <b>类 描 述</b> :  斐波那契数列计算示例,注:千万不要真正使用这个递归任务来计算斐波那契数列,递归计算时间和空间复杂度不现实<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/28 21:08<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/28 21:08<br/>
 * <b>修改备注</b> :  <br/>
 * 时间复杂度 = 递归的次数 * 每次递归的时间复杂度<br/>
 * 递归算法的空间复杂度 = 递归的深度* 每次递归的空间复杂度
 * @author zdk
 */
public class Fibonacci extends RecursiveTask<Integer> {
    final int n;
    
    Fibonacci(int n) {
        this.n = n; 
    }
    
    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }
}
