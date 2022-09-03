package base.foreach;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <b>类 名 称</b> :  ForEachTest<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/7/31 16:35<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/7/31 16:35<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class ForEachTest {
    
    private static Logger LOGGER = LoggerFactory.getLogger(ForEachTest.class);

    public static void main(String[] args) {
        foreachOrderlyTest();
    }
    
    public static void iterableTest() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
        int i = 5;
        Iterable<Integer> iterable = integers;
        for (Integer integer : iterable) {
            System.out.println(integer + "===");
            integers.set(2,i++);
        }
    }

    /**
     * foreach遍历会保证顺序
     */
    public static void foreachOrderlyTest() {
        List<Integer> oneHundred = Stream.iterate(1, i -> ++i).limit(1000).collect(Collectors.toList());
        int i = 1;
        for (Integer integer : oneHundred) {
            if (i != integer) {
                LOGGER.error("100以内循环遍历未按顺序,出错位置:{},出错值:{}", i, integer);
                break;
            }
            i++;
        }
    }
    
}
