package com.szx.netty.concurrent_chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParkCountTest {
    public static void main(String[] args) {
        ParkCount parkCount = new ParkCount(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < parkCount.getDoors().size(); i++){
            executorService.execute(parkCount.getDoors().get(i));
        }
        try {
            Thread.sleep(1000);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < parkCount.getDoors().size(); i++){
            System.out.println("door index"+parkCount.getDoors().get(i).getName()+":"+parkCount.getDoors().get(i).getDoorCounter().get());
        }
        System.out.println("total count:"+ parkCount.getTotalCount().get());
    }
}
