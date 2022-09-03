package juc.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * <b>类 名 称</b> :  StampedLock<br/>
 * <b>类 描 述</b> :  票据锁(邮戳锁)<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/9/3 14:26<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/9/3 14:26<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class StampedLockTest {

    public static void main(String[] args) {
        t();
    }

    public static void t() {
        Point a = new Point();
        a.move(3, 0);
        Point b = new Point();
        b.move(0, 4);
        System.out.println(a.distanceFromOrigin());
        System.out.println(b.distanceFromOrigin());
        b.move(3, 0);
        System.out.println(b.distanceFromOrigin());
    }

    /**
     * 二维点
     */
    static class Point {
        private double x, y;
        private final StampedLock sl = new StampedLock();

        void move(double deltaX, double deltaY) { // an exclusively locked method
            long stamp = sl.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                sl.unlockWrite(stamp);
            }
        }

        /**
         * 计算两点的距离
         * @return 距离
         */
        double distanceFromOrigin() { // A read-only method
            long stamp = sl.tryOptimisticRead();
            double currentX = x, currentY = y;
            if (!sl.validate(stamp)) {
                stamp = sl.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

        /**
         * 如果当前在原点,则移动到指定位置
         * @param newX x坐标
         * @param newY y坐标
         */
        void moveIfAtOrigin(double newX, double newY) { // upgrade
            // Could instead start with optimistic, not read mode
            long stamp = sl.readLock();
            try {
                while (x == 0.0 && y == 0.0) {
                    long ws = sl.tryConvertToWriteLock(stamp);
                    if (ws != 0L) {
                        stamp = ws;
                        x = newX;
                        y = newY;
                        break;
                    } else {
                        sl.unlockRead(stamp);
                        stamp = sl.writeLock();
                    }
                }
            } finally {
                sl.unlock(stamp);
            }
        }
    }
}
