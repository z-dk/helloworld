package juc.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * <b>类 名 称</b> :  SkipTable<br/>
 * <b>类 描 述</b> :  跳跃表,跳表<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/10/23 10:38<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/10/23 10:38<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class SkipTable {

    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Map<String, String>> skipTable = new ConcurrentSkipListMap<>();
        skipTable.put("213", new HashMap<>());
        
    }
    
}
