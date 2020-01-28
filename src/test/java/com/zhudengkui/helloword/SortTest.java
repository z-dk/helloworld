package com.zhudengkui.helloword;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * <b>类 名 称</b> :  SortTest<br/>
 * <b>类 描 述</b> :  ***<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/12/4 18:13<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/12/4 18:13<br/>
 * <b>修改备注</b> :
 */
public class SortTest {
    
    public static void main(String[] args) {
        
        List<Map<String,Object>> list = new ArrayList<>();
        List<Map<String,Object>> resultList = new ArrayList<>();
        for (int j=10;j<20;j++) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 10; i < 34; i++) {
                map.put("usd" + i, BigDecimal.valueOf(Math.random() * 100)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
            }
            list.add(map);
        }
        
        
        //************初次实现方式
        
        for (Map<String,Object> map : list){
            List<Map.Entry<String, Object>> list1 = new ArrayList<>(map.entrySet());
            list1.sort(Comparator.comparing(o -> new BigDecimal(o.getValue().toString())));
            
            Iterator<Map.Entry<String, Object>> iter = list1.iterator();
            Map.Entry<String, Object> tmpEntry = null;
            Map<String, Object> sortedMap = new LinkedHashMap<>();
            while (iter.hasNext()) {
                tmpEntry = iter.next();
                sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
            }
            resultList.add(sortedMap);
        }
        
        resultList.sort((o1, o2) -> {
            List<Map.Entry<String, Object>> list1 = new ArrayList<>(o1.entrySet());
            List<Map.Entry<String, Object>> list2 = new ArrayList<>(o2.entrySet());
        
//            list1.sort(Map.Entry.comparingByKey());
//            list2.sort(Map.Entry.comparingByKey());
            return list2.get(list2.size()-1).getValue().toString().compareTo(list1.get(list1.size()-1).getValue().toString());
        });
    
        Map<String, Object> map = resultList.get(0);
        resultList.removeIf(o -> o.get("111").equals("ee"));
        try {
            Field tail = map.getClass().getDeclaredField("tail");
            tail.setAccessible(true);
            Map.Entry<String,Object> o = (Map.Entry<String, Object>) tail.get(map);
            System.out.println(o.getKey()+":"+o.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println();
        
    }
    
    
    
    
    public static Map<String, BigDecimal> sortMapByValue(Map<String, BigDecimal> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, BigDecimal> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, BigDecimal>> list = new ArrayList<>(oriMap.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        System.out.println("*********************************");
        for (Map.Entry<String, BigDecimal> mapping : list) {
            System.out.println(mapping.getKey() + " ：" + mapping.getValue());
        }
        System.out.println("*********************************");
        Iterator<Map.Entry<String, BigDecimal>> iter = list.iterator();
        Map.Entry<String, BigDecimal> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
    
}
