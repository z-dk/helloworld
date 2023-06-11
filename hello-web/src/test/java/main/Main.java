package main;

public class Main {



    public static void main(String[] args) {
        int x = 5, y = 7;
        x = x ^ y;
        y = y ^ x;
        x = x ^ y;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println(Integer.numberOfLeadingZeros(15));
    }

}
