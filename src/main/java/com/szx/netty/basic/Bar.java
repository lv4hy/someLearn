package com.szx.netty.basic;

public class Bar extends Foo{
    int j = 1;

    public Bar(){
        System.out.println("j="+j);
        int x = getValue();
        System.out.println("bar x="+x);
    }

    {
        j = 2;
    }

    public int getValue(){
        return j;
    }


}
