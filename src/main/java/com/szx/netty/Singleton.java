package com.szx.netty;

public class Singleton {
    private static Singleton instance;

    static {
        System.out.println("singleton exec");
        instance = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

}
