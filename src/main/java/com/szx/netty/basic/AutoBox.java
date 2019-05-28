package com.szx.netty.basic;

public class AutoBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 331;
        Integer f = 331;
        Long g = 3333L;
        long h = 3333;

        System.out.println(c == d);
        System.out.println((e+1) == (f+1));
        System.out.println( c == (a+b));
        System.out.println( c.equals(a+b));
        System.out.println( g == (a+b));
        System.out.println( g == h);
        System.out.println( g.equals(h));

    }
}
