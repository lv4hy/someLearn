package com.szx.netty;

public class Singleton2 {

    private Singleton2(){}


    private static class Inner {
        public static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return Inner.instance;
    }
}
