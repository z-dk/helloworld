package juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private final int n;

    private final Semaphore z = new Semaphore(1);
    private final Semaphore e = new Semaphore(0);
    private final Semaphore o = new Semaphore(1);
    private final AtomicInteger curr = new AtomicInteger(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() <= n || (curr.get() == 1 && n == 1)) {
            if (!z.tryAcquire(1, 2, TimeUnit.SECONDS)) {
                break;
            }
            if (curr.get() <= n || (curr.get() == 1 && n == 1)) {
                printNumber.accept(0);
                e.release(1);
                o.release(1);
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() <= n) {
            if (!e.tryAcquire(2, 2, TimeUnit.SECONDS)) {
                break;
            }
            printNumber.accept(curr.getAndAdd(1));
            z.release(1);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() <= n) {
            if (!o.tryAcquire(2, 2, TimeUnit.SECONDS)) {
                break;
            }
            printNumber.accept(curr.getAndAdd(1));
            z.release(1);
        }
    }
}
