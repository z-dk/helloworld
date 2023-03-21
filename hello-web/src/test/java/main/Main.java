package main;

import org.assertj.core.util.Lists;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> rs = new HashMap<>();
        rs.put("1", 1);
        rs.put("2", 1);
        rs.put("3", 1);
        rs.put("5", null);
        List<Integer> integers = Lists.newArrayList(54, 234, 67, 2, 6, null, 99, null, -1);
        integers.sort(Comparator.comparing(i -> i, Comparator.nullsLast(Comparator.reverseOrder())));
        //integers.sort(Comparator.comparing(i -> i, Comparator.reverseOrder()));

        System.out.println(integers);


        // 除不尽时报错
        //BigDecimal divide = new BigDecimal("10").divide(new BigDecimal("4"));
        //System.out.println(divide);


    }

}
