package com.szx.netty.concurrent_chapter21;

import java.util.concurrent.atomic.AtomicInteger;

public class Door {
    private AtomicInteger doorCounter = new AtomicInteger(0);

    public void enter(){

        doorCounter.incrementAndGet();
    }
}
