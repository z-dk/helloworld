package juc;

/**
 * <b>类 名 称</b> :  Synchronize<br/>
 * <b>类 描 述</b> :  synchronize测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/16 15:26<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/16 15:26<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Synchronize {

    /**
     * wait/notify方法的调用必须在该对象的锁(Monitor)中,否则抛出IllegalMonitorStateException异常
     * notify方法调用之后只有等待代码退出synchronized块后,其他线程才可以获取到锁
     */
    private final Object lock = new Object();
    private boolean envReady = false;

    public static void main(String[] args) {
        Synchronize sync = new Synchronize();
        sync.startWork();
        sync.prepareEnv();
    }
    
    public void startWork() {
        new WorkerThread().start();
    }
    
    public void prepareEnv() {
        new PrepareEnvThread().start();
    }
    
    private class WorkerThread extends Thread {
        public void run() {
            System.out.println("线程 WorkThread 等待获取锁");
            synchronized (lock) {
                try {
                    System.out.println("线程 WorkThread 获取到锁");
                    if (!envReady) {
                        System.out.println("线程 WorkThread 放弃锁,wait");
                        lock.wait();
                    }
                    System.out.println("线程 WorkThread 收到通知后继续执行");
                } catch (InterruptedException e) {
                    
                }
            }
        }
    }
    
    private class PrepareEnvThread extends Thread {
        public void run() {
            System.out.println("线程 PrepareEnvThread 等待获取锁");
            synchronized (lock) {
                System.out.println("线程 PrepareEnvThread 获取到锁");
                envReady = true;
                lock.notify();
                System.out.println("通知 WorkThread");
            }
        }
    }
    
}
