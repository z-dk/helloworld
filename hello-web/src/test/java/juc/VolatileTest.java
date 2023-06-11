package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        //visibility();
        //atomic();
        order();
    }

    /**
     * happen-before的传递性
     * 操作1 happens-before 操作2，
     * 操作2 happens-before 操作3，
     * 那么操作1 happens-before 操作3
     * 这里只要set先执行,即使a未加volatile，也能保证d的值为1,a为5
     */
    static class A {
        private int a = 0;
        private volatile int c = 0;

        private int d = 0;
        public void set() {
            a = 5;  // 操作1
            c = 1;  // 操作2
        }
        public int get() {
            d = c;  // 操作3
            return a;   // 操作4
        }
    }

    /**
     * 验证volatile的有序性
     */
    static void order() {
        MyData myData = new MyData();
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            myData.addTo60();
            myData.flag = true;
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number2);
        }, "AAA").start();

        new Thread(() -> {
            while (!myData.flag) {
                System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value: " + myData.number2);
            }
        }, "BBB").start();
    }

    /**
     * volatile 不保证原子性
     */
    static void atomic() {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addPlusPlusSync();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都全部计算完成后,再用main线程取得最终的结果值看是多少?
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int type, finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type, finally number value: " + myData.atomicInteger);
    }

    /**
     * volatile 保证可见性
     */
    static void visibility() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {
            // main线程就一直在这里等待循环，直到number值不再等于零
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value: " + myData.number);
    }

    private static class MyData {

        // volatile关键词保证了可见性,如果不加volatile关键词,则线程AAA修改了number的值,但是线程main无法感知到
        volatile int number = 0;

        int number2 = 0;

        boolean flag = false;

        // AtomicInteger保证了可见性和原子性
        AtomicInteger atomicInteger = new AtomicInteger();

        public void addTo60() {
            this.number = 60;
            this.number2 = 60;
        }

        public void addPlusPlus() {
            number++;
        }

        public void addPlusPlusSync() {
            atomicInteger.addAndGet(1);
        }

    }
}
