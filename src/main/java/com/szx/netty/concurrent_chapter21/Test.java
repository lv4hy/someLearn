package com.szx.netty.concurrent_chapter21;

public class Test implements Runnable{

    public Test() {

    }

    private int count = 3;
    @Override
    public void run() {
        while (count > 0){
            System.out.println("haha");
            Thread.yield();
            count--;
        }

    }
}
