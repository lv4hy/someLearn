package com.szx.netty.concurrent_chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;
    private int result;

    public ThreadMethod(String name) {
        this.name = name;
    }
    public void runTask(){
        if(t == null){
            t = new Thread(name){
                @Override
                public void run(){
                    try {
                        while (true){
                            System.out.println(this);
                            if(-- countDown == 0){
                                return;
                            }
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                @Override
                public String toString(){
                    return getName() + ":"+countDown;
                }
            };
            t.start();
        }
    }

    public Future runTask(int num){
        ExecutorService service = Executors.newFixedThreadPool(1);

        Callable<Integer> callable = new Callable<Integer>() {
            List<Integer> arrary = new ArrayList<>();
            @Override
            public Integer call() throws Exception {
                for(int i = 0; i < num; i++){
                    if(i == 0){
                        arrary.add(1);
                    }else if (i == 1){
                        arrary.add(1);
                    }else {
                        arrary.add(arrary.get(i - 1) + arrary.get(i - 2));
                    }
                }

                for(int i = 0; i < arrary.size(); i++){
                    result += arrary.get(i);
                }
                return result;
            }
        };
        return service.submit(callable);
    }
}
