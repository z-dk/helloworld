package main;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        int x = 5, y = 7;
        x = x ^ y;
        y = y ^ x;
        x = x ^ y;
        Integer i = 1;
        String s = Integer.toBinaryString(i);
        StringBuilder sb = new StringBuilder(s);
        for (int i1 = s.length() - 1; i1 >= 0; i1--) {
            sb.append(s.charAt(i1));
        }
        Integer.valueOf(sb.toString(), 2);
        System.out.println("x = " + x + ", y = " + y);
        System.out.println(Integer.numberOfLeadingZeros(15));

        List<Integer> list = new ArrayList<>();
        list.toArray(new Integer[0]);
    }

}
