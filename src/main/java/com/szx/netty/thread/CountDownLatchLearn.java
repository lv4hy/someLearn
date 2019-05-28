package com.szx.netty.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchLearn {

    static class Task implements Runnable{

        @Override
        public void run() {
            int result = 0;
            for(int i = 0; i < 1000000; i++){
                result += i;
            }
        }
    }


    public void countTotalWithNThread(int threads, Runnable task) throws InterruptedException {

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threads);

        for(int i = 0; i < threads; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        }finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }

        Long startTime = System.nanoTime();
        startGate.countDown();
        endGate.await();
        Long endTime = System.nanoTime();
        System.out.println(threads + "threas run total time: "+ (endTime - startTime)/1000);

    }

    public static void main(String[] args) {
        CountDownLatchLearn lean = new CountDownLatchLearn();
        try {
            lean.countTotalWithNThread(5, new Task());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
