package com.szx.netty.concurrent_chapter21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ThreadVariations {
    public static void main(String[] args) {
        /*new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunable1("InnerRunable1");
        new InnerRunnale2("InnerRunable2");
        new ThreadMethod("threadmethod").runTask();*/

        Future<Integer> resultFuture = new ThreadMethod("threadMethod1").runTask(4);
        try {
            System.out.println(resultFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
