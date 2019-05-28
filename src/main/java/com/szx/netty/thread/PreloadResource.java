package com.szx.netty.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask提前加载稍后需要的数据
 */
public class PreloadResource {

    private final FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "haha";
        }
    });

    Thread thread = new Thread(futureTask);

    public void start(){
        thread.start();
    }

    public String getResource() throws ExecutionException, InterruptedException {
        return futureTask.get();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        PreloadResource preloadResource = new PreloadResource();
        preloadResource.start();
        Thread.sleep(5000);
        System.out.println(System.currentTimeMillis() + "start get resource");
        System.out.println(preloadResource.getResource());
        System.out.println(System.currentTimeMillis() + "get resource end");


    }
}
