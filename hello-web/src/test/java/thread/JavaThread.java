package thread;

/**
 * <b>类 名 称</b> :  JavaThread<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/10/6 16:40<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/10/6 16:40<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class JavaThread {

    public static void main(String[] args) {
        //isInterrupt();
        //interrupt();
        

        start2();
    }

    static void start2() {
        Object obj = new Object();
        Thread t = new Thread(() -> {
            System.out.println("hello");
            try {
                synchronized (obj) {
                    System.out.println("wait");
                    obj.wait();
                    System.out.println("wait end");
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        });
        t.start();
        t.interrupt();
        System.out.println("world");
        // 第二次调用start方法会抛出IllegalThreadStateException异常(状态不对)
        //t.start();
    }

    static void isInterrupt() {
        Thread thread = Thread.currentThread();
        System.out.println("是否中断了：" + Thread.interrupted() + "，清除了中断");

        System.out.println("是否中断了：" + thread.isInterrupted());
        // 中断主线程，设置中断标志位，但不会中断主线程，如果中断的线程处于阻塞状态，会抛出InterruptedException异常
        thread.interrupt();
        System.out.println("是否中断了：" + thread.isInterrupted());
        System.out.println("是否中断了：" + Thread.interrupted() + "，清除了中断");
        System.out.println("是否中断了：" + thread.isInterrupted());
    }

    static void interrupt() {
        // 创建一个MyThread对象
        MyThread myThread = new MyThread();
        // 用该对象创建一个线程
        Thread thread = new Thread(myThread);
        // 启动线程
        thread.start();
        // 主线程休眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 中断子线程
        thread.interrupt();
    }

    // 定义一个线程类，实现Runnable接口
    static class MyThread implements Runnable {
        // 重写run方法
        public void run() {
            // 循环打印当前线程的名称
            while (true) {
                System.out.println(Thread.currentThread().getName() + " status: " + Thread.currentThread().isInterrupted());
                // 模拟耗时操作
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // InterruptedException异常会清除中断标志位，所以需要重新设置中断标志位
                    System.out.println("Exception handled and interrupt is :" + Thread.currentThread().isInterrupted());
                    // 捕获InterruptedException后，恢复中断状态
                    Thread.currentThread().interrupt();
                    // 打印异常信息
                    System.out.println("Exception handled " + e);
                    // 退出循环
                    break;
                }
            }
        }
    }
    
}
