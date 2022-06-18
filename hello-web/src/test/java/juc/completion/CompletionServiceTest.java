package juc.completion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * <b>类 名 称</b> :  completionServiceTest<br/>
 * <b>类 描 述</b> :  completionService类使用示例<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/6/18 16:02<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/6/18 16:02<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class CompletionServiceTest {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CompletionService<String> service = new ExecutorCompletionService<>(pool);

        Map<String, Integer> fruitMap = new HashMap<>(16);
        fruitMap.put("苹果", 5);
        fruitMap.put("桃", 4);
        fruitMap.put("西瓜", 10);
        fruitMap.put("葡萄", 1);
        Stream.of("苹果", "桃", "西瓜", "葡萄").forEach(fruit -> service.submit(() -> {
            Thread.sleep(fruitMap.get(fruit));
            return "刚洗了的:" + fruit;
        }));
        
        String rs;
        while ((rs = service.take().get()) != null) {
            System.out.println("吃掉" + rs);
        }
        
    }
    
    
    
}
