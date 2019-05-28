package com.szx.netty.thread;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OutOfTime {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new Task(), 1000);
        SECONDS.sleep(1);
        timer.schedule(new Task(), 1000);
        Thread.sleep(1000);
    }

    static class Task extends TimerTask{
        @Override
        public void run() {
            System.out.println("start ...");
            //throw new RuntimeException();
        }
    }
}
