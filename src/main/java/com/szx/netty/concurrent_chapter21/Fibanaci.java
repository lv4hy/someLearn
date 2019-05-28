package com.szx.netty.concurrent_chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Fibanaci implements Runnable {
    private final int n;
    private List<Integer> result = new ArrayList<>();
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public Fibanaci(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if(n <= 0){
            return;
        }
        for(int i = 1; i <= n; i++){
            if(i == 1){
                result.add(1);
            }else if(i == 2){
                result.add(1);
            }else {
                result.add(result.get(i - 2) + result.get(i - 3));
            }
        }
        countDownLatch.countDown();
    }

    public List<Integer> getResult() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
