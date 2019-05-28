package com.szx.netty.concurrent_chapter21;

public class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run(){
        try {
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
