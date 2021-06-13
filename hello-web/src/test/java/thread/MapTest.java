package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <b>类 名 称</b> :  MapTest<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/9/13 9:02<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/9/13 9:02<br/>
 * <b>修改备注</b> :
 */
public class MapTest {
    
    public static void main(String[] args) {
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        ThreadLocal<Map<String,Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);
        threadLocal.set(map);
        test(map);
    }
    
    private static void test(ConcurrentHashMap<String,Object> map){
        map.put("string","object");
        map.putIfAbsent("string","absent");
        System.out.println(map.get("string"));
        
    }
    
}
