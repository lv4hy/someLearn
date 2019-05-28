package com.szx.netty.concurrent_chapter21;

public class Joinning {

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);

        Joiner dopey = new Joiner("dopey", sleeper);
        Joiner doc = new Joiner("Doc", grumpy);

        grumpy.interrupt();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            System.out.println("thread sleep 1s");
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }


}
