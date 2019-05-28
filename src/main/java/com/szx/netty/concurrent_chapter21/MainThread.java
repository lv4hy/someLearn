package com.szx.netty.concurrent_chapter21;

import java.util.Arrays;
import java.util.List;

public class MainThread {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            Fibanaci fibanaci = new Fibanaci(5);
            Thread thread = new Thread(fibanaci);
            thread.setName("thread-"+i);
            thread.start();
            print(fibanaci.getResult());
        }


        /*ListOff listOff = new ListOff();
        listOff.run();*/
    }

    public static void print(List<Integer> result){
        if(result == null){
            return;
        }
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
