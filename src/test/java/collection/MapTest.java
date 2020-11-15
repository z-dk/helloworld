package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>类 名 称</b> :  MapTest<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/15 19:42<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/15 19:42<br/>
 * <b>修改备注</b> :
 */
public class MapTest {
    
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(16);
        map.put("1111","14");
        map.forEach((k,v) -> System.out.println(k+":"+v));
    }
    
    private static void entryTest(Map<String,? super String> map) {
        
    }
    
}
