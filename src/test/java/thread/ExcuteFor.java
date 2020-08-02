package thread;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>类 名 称</b> :  ExcuteFor<br/>
 * <b>类 描 述</b> :  多线程执行for循环<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/1/16 15:11<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/1/16 15:11<br/>
 * <b>修改备注</b> :
 */
public class ExcuteFor {
//    private final static Executor executor = Executors.newFixedThreadPool(3);// 启用多线程
    public static void main(String[] args) {
        Map<String,String> result = new HashMap<>();
    
        ExecutorService executor = Executors.newFixedThreadPool(3);// 启用多线程
        
        List<String> list = new ArrayList<>();
        list.add("1111111111");
        list.add("2222222222");
        long s = System.currentTimeMillis();
        for (String e : list) {
            executor.execute(() -> {
                Double text = (double) 0;
                for (long i=0;i<100000000;i++){
                    double random = Math.random();
                    if (random > text){
                        text = random;
                    }
                }
                result.put(e,text.toString());
            });
        }
        /*System.out.println("结束了！===="+(System.currentTimeMillis()-s));
        for (Map.Entry entry : result.entrySet()){
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        }*/
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                System.out.println("结束了！===="+(System.currentTimeMillis()-s));
                for (Map.Entry entry : result.entrySet()){
                    System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
                }
                break;
            }
        }
    }
}
