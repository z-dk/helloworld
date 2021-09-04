package collection;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>类 名 称</b> :  Iterator<br/>
 * <b>类 描 述</b> :  迭代器测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/9/12 17:57<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/9/12 17:57<br/>
 * <b>修改备注</b> :
 */
public class IteratorTest {
    
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
//        iteratorTest();
//        byte[] seed = SecureRandom.getSeed(1);
        SecureRandom secureRandom = new SecureRandom();
        synchronized (object) {
            object.wait();
        }
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        for (int i = 0; i<10;i++) {
            System.out.println(secureRandom.nextInt(10));
        }
    }
    
    public static void iteratorTest(){
        List<String> list = new ArrayList<>(Arrays.asList("1,2,3,4,5".split(",")));
        System.out.println("初始list的大小："+list.size());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("3")){
                list.remove(next);
            }
//            iterator.remove();
        }
        System.out.println("剩余list的大小："+list.size());
    }
}
