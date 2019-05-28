package com.szx.netty.thread;

public class LockTest {
    volatile int size = 0;
    public synchronized void increase(){
        size++;
    }
    public synchronized int current(){
        return size;
    }

    class ThreadOne implements Runnable{

        @Override
        public void run() {
            for(int i = 0 ; i < 100; i++){
                increase();
            }
            System.out.println("thread a "+ current());
        }
    }

    class ThreadTwo implements Runnable{

        @Override
        public void run() {
            for(int i = 0 ; i < 100; i++){
                increase();
            }
            System.out.println("thread b "+ current());
        }
    }

    public static void main(String[] args) {
        ThreadOne lock = new LockTest().new ThreadOne();

        Thread thread1 = new Thread(lock);
        Thread thread2 = new Thread(lock);
        thread1.start();
        thread2.start();
    }

}
