package com.szx.netty.concurrent_chapter21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

    private static Lock lock = new ReentrantLock();
    public static void unTime(){
        boolean capture = lock.tryLock();
        try {
            System.out.println("untime get lock? "+ capture);
            TimeUnit.MILLISECONDS.sleep(2001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(capture){
                lock.unlock();
            }
        }
    }

    public static void timed(){
        boolean capture = false;
        try {
            capture = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("timed get lock? " + capture);
        }finally {
            if(capture){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        AttemptLocking locking = new AttemptLocking();
        new Thread(AttemptLocking::timed).start();
        new Thread(AttemptLocking::unTime).start();
    }

}
