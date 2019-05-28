package com.szx.netty.concurrent_chapter21;

import java.util.concurrent.TimeUnit;

public class InnerRunnale2 {

    private int countDown = 5;
    private Thread t;

    public InnerRunnale2(String name) {

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println(this);
                        if(--countDown == 0){
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            @Override
            public String toString(){
                return Thread.currentThread().getName() + ":" + countDown;
            }
        }, name);

        t.start();
    }
}
