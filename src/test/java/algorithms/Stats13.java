package algorithms;

import com.fasterxml.jackson.databind.BeanProperty;
import com.sun.net.httpserver.Filter;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

/**
 * <b>类 名 称</b> :  Stats13<br/>
 * <b>类 描 述</b> :  背包、队列和栈<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/12/7 20:15<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/12/7 20:15<br/>
 * <b>修改备注</b> :
 */
public class Stats13 {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("AAAA");
        all.add("BBBB");
        all.add("CCCC");
        all.add("DDDD");
        all.add("DDDD");
        List<String> aa = new ArrayList<>();
        aa.add("CCCC");
        aa.add("DDDD");
        String bb = "DDDD";
    
        for (int i=0;i<all.size();i++){
            if (all.get(i).contains("C")){
                all.remove(i);
                i--;
            }
        }
        for (Iterator<String> it = all.iterator(); it.hasNext(); ) {
            if (it.next().contains("C")){
                it.remove();
            }
        }
        System.out.println(all.size());
    }
    
    public static void removeIfTest(){
        Map<String,Object> rootMap = new HashMap<>();
        Map<String,Object> childMap = new HashMap<>();
        rootMap.put("A","aa");
        childMap.put("A","a");
        childMap.put("B","b");
        rootMap.putAll(childMap);
        System.out.println(rootMap.get("A"));
    
        List<Map<String,Object>> list = new ArrayList<>();
        List<Map<String,Object>> resu = new ArrayList<>();
    
        Map<String,Object> map = new HashMap<>();
        map.put("code","234");
        map.put("name","jilin");
        list.add(map);
    
        Map<String,Object> rsmap = new HashMap<>();
        rsmap.put("code","234");
        rsmap.put("num","3434");
        resu.add(rsmap);
    
        list.removeIf(resu::contains);
//        removeIfTest();
    }
    
    public void textRemoveIf(){
        List<String> all = new ArrayList<>();
        all.add("AAAA");
        all.add("BBBB");
        all.add("CCCC");
        all.add("DDDD");
        all.add("DDDD");
        List<String> aa = new ArrayList<>();
        aa.add("CCCC");
        aa.add("DDDD");
        String bb = "DDDD";
    
        all.removeIf(aa::contains);
    
        System.out.println(all.size());
    }
    
    public void testA(){
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()){
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum/N;
        sum = 0.0;
        for (double x : numbers)
            sum += (x-mean)*(x-mean);
        double std = Math.sqrt(sum/(N-1));
        StdOut.printf("Mean: %2f\n",mean);
        StdOut.printf("Std dev: %2f\n",std);
    }
}
