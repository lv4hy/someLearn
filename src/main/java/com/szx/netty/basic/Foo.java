package com.szx.netty.basic;

public class Foo {
    private int i = 1;

    public Foo(){
        System.out.println("i="+i);
        int x = getValue();
        System.out.println("foo, x=" + x);
    }

    {
        i = 2;
    }

    public int getValue(){
        return i;
    }
}
