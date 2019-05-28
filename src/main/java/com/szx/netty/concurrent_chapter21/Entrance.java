package com.szx.netty.concurrent_chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable{
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();

    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;


    public static void cancel(){
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled){
            synchronized (this){
                ++number;
            }
            System.out.println(this + ", total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("stopping "+ this);

    }

    public synchronized int getValue(){
        return number;
    }

    @Override
    public String toString(){
        return "entrance: "+ id + " :" + getValue();
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int sumEntrance(){
        int sum = 0;
        for(Entrance entrance : entrances){
            sum += entrance.getValue();
        }
        return sum;
    }
}
