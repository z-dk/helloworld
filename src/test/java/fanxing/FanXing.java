package fanxing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <b>类 名 称</b> :  FanXing<br/>
 * <b>类 描 述</b> :  泛型测试类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/8/7 20:32<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/8/7 20:32<br/>
 * <b>修改备注</b> :
 */
public class FanXing {
    
    public static void main(String[] args) {
        String[] split = "1,2,3,4,,".split(",");
        System.out.println(split.length + Arrays.toString(split));
    }
    
    public static void test(){
        List<?> p = new ArrayList<>();
    }
    
}
