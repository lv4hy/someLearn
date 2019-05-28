package com.szx.netty.thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InterruptedLearn {
    private static final ScheduledThreadPoolExecutor cancelExec = new ScheduledThreadPoolExecutor(1);

    public static void main(String[] args) {

    }

    public static void timedRun(final Runnable r,
                                long timeout,
                                TimeUnit unit) throws Throwable {
        class RethrowableTask implements Runnable{
            private volatile Throwable t;
            @Override
            public void run() {
                try {
                    r.run();
                }catch (Throwable t){
                    this.t = t;
                }
            }

            void rethrow() throws Throwable {
                if(t != null){
                    throw new Throwable(t);
                }
            }
        }
        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }
}
