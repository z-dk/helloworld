package base.foreach;

import com.google.common.collect.Lists;

import java.util.ArrayList;

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

    public static void main(String[] args) {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
        int i = 5;
        Iterable<Integer> iterable = integers;
        for (Integer integer : iterable) {
            System.out.println(integer + "===");
            integers.set(2,i++);
        }
    }
    
}
