package com.szx.netty;

import org.junit.Test;

import static org.junit.Assert.*;

public class Singleton2Test {

    @Test
    public void singleTest(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    Singleton singleton = Singleton.getInstance();
                    System.out.println("singleton:" + singleton.hashCode());
                }
            }
        });



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    Singleton2 singleton2 = Singleton2.getInstance();
                    System.out.println("singleton2:" + singleton2.hashCode());
                }
            }
        });

        thread1.run();
        thread2.run();
    }
}