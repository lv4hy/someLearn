package com.szx.netty.thread;

public class ThreadB extends Thread{
    private ObjectService service;
    public ThreadB(String name, ObjectService service) {
        super(name);
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.methodB();
    }
}
