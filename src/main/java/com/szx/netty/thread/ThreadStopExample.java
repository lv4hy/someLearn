package com.szx.netty.thread;

import java.util.concurrent.TimeUnit;

public class ThreadStopExample {
    private static boolean stop;

    public static void main(String[] args) {
        Thread workThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stop){
                    i++;
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("i = " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread stop");
            }
        });
        workThread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3s  has pass");
        stop = true;
        System.out.println("stop done");
    }
}
