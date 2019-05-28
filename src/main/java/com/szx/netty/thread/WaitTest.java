package com.szx.netty.thread;

import org.springframework.web.util.pattern.PathPattern;

import java.util.Observable;

public class WaitTest {
    private static Object object = new Object();
    private static final String[] buf = new String[3];
    private static int count = 0;
    private static int head = 0;
    private static int tail = 0;

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++){
                        System.out.println(get());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i< 100; i++){
                        put(String.valueOf(i));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
    };


    private static String get() throws InterruptedException {
        synchronized (object){
            System.out.println("has enter get lock");
            while(!isNotEmpty()){
                object.wait();
            }
            String value = buf[head];
            buf[head] = null;
            count--;
            head ++;
            if(head == 3){
                head = 0;
            }
            object.notifyAll();
            return value;
        }
    }

    private static void put(String value) throws InterruptedException {
        synchronized (object){
            System.out.println("has enter put lock");
            while (!isNotFull()){
                object.wait();
            }
            buf[tail] = value;
            tail++;
            if(tail == 3){
                tail = 0;
            }
            count++;
            object.notifyAll();

        }

    }

    private static synchronized boolean isNotFull(){
        return !(count == 3);
    }

    private static synchronized boolean isNotEmpty(){
        return !(count == 0);
    }
}
