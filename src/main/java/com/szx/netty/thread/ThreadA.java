package com.szx.netty.thread;

public class ThreadA extends Thread{

    private ObjectService service;

    public ThreadA(String name, ObjectService service) {
        super(name);
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.methodA();
    }
}
