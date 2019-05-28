package com.szx.netty.concurrent_chapter21;

import org.apache.catalina.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool(new HandlerThreadFactory());
        ex.execute(new ExceptionThread2());
    }
}
