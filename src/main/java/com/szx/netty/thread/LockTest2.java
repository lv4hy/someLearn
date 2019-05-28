package com.szx.netty.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest2 {
    private static ReentrantLock lock = new ReentrantLock();
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("threadA has get lock");
                try {
                    System.out.println("threadA has sleep");
                    Thread.sleep(2000);
                    System.out.println("threadA sleep over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("threadB has get lock");
                try {
                    System.out.println("threadB has sleep");
                    Thread.sleep(3000);
                    System.out.println("threadB sleep over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        /*threadA.start();
        threadB.start();*/

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("threadC has get lock");
                    while (!flag){
                        System.out.println("threadC condition not meet");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = false;
                    lock.notifyAll();
                }
            }
        });


        Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("threadD get lock");
                    while (flag){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = true;
                    lock.notifyAll();
                }
            }
        });

        threadC.start();
        threadD.start();

    }
}
