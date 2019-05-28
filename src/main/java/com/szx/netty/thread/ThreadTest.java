package com.szx.netty.thread;

public class ThreadTest {

    public static void main(String[] args) {
        ObjectService objectService = new ObjectService();
        ThreadA threadA = new ThreadA("A", objectService);
        threadA.start();

        ThreadB threadB = new ThreadB("B", objectService);
        threadB.start();
    }
}
