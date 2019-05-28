package com.szx.netty.basic;

public class ThreadTest extends Thread{

    public ThreadTest() {
        Thread.currentThread().setName("thread test");
        printName();
    }

    public void printName(){
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run(){
        Thread.currentThread().setName("thread test");
        printName();
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Thread.currentThread().setName("thread main");
        threadTest.start();
    }
}
