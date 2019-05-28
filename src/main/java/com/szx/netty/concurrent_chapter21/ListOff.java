package com.szx.netty.concurrent_chapter21;

public class ListOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public ListOff(){}

    public ListOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id +"(" +
                (countDown > 0 ? countDown : "Listoff!") + ").";

    }

    @Override
    public void run() {
        while (countDown > 0){
            System.out.println("thread name: "+Thread.currentThread().getName());
            System.out.println(status());
            countDown--;
            //Thread.yield();
        }
    }
}
