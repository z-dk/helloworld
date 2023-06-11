package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
        //iteratorTest();
        iteratorCOWATest();
    }
    
    public static void iteratorTest(){
        List<String> list = new ArrayList<>(Arrays.asList("1,2,3,4,5".split(",")));
        System.out.println("初始list的大小："+list.size());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("5")){
                list.remove(next);
            }
//            iterator.remove();
        }
        System.out.println("剩余list的大小："+list.size());
    }

    public static void iteratorCOWATest(){
        List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("1,2,3,4,5".split(",")));
        System.out.println("初始list的大小："+list.size());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("2")){
                list.remove(next);
            }
//            iterator.remove();
        }
        System.out.println("剩余list的大小："+list.size());
    }
}
