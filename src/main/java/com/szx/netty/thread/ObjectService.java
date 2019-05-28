package com.szx.netty.thread;

public class ObjectService {

    private Object object = new Object();
    private boolean flag = true;
    private volatile int i = 0;

    public  void methodA(){
        synchronized (object){
            System.out.println("thread" + Thread.currentThread().getName() + "start");
            try {
                i = 10;
                System.out.println("method A: i="+ i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread"+Thread.currentThread().getName() + "end");
            if(flag){
                i = 12;
                flag = false;
            }
        }

    }

    public synchronized void methodB(){
        System.out.println("thread" + Thread.currentThread().getName() + "start");
        try {
            System.out.println("method B, i="+ i);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method B, i="+ i);
        System.out.println("thread" + Thread.currentThread().getName() + "end");

    }
}
