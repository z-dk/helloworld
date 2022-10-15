package main;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // 除不尽时报错
        BigDecimal divide = new BigDecimal("10").divide(new BigDecimal("4"));
        System.out.println(divide);


    }

}
