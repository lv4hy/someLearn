package com.szx.netty.thread;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.*;

public class Memoizer3<A,V> implements Computable<A, V>{

    private final ConcurrentMap<A, FutureTask<V>> cache = new ConcurrentHashMap<A, FutureTask<V>>();
    private final Computable computable;

    public Memoizer3(Computable computable) {
        this.computable = computable;
    }

    @Override
    public V compute(A arg) throws Exception {
        while (true){
            Future<V> future = cache.get(arg);
            if(future == null){
                FutureTask<V> futureTask = new FutureTask<>(new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return (V) computable.compute(arg);
                    }
                });
                future = cache.putIfAbsent(arg, futureTask);
                if(future == null){
                    future = futureTask;
                    futureTask.run();
                }
            }

            try {
                return future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
                cache.remove(arg);
                throw new Exception(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        Memoizer3<String, BigInteger> memoizer3 = new Memoizer3<>(new ExpensiveFunction());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread1 start compute arg:a, start time :"+ System.currentTimeMillis());
                    BigInteger result = memoizer3.compute("a");
                    System.out.println("thread1 end compute arg:a, end time :"+System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threa2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Thread.sleep(1000);
                    System.out.println("thread2 start compute arg:a, start time :"+System.currentTimeMillis());
                    BigInteger result2 = memoizer3.compute("a");
                    System.out.println("thread2 end compute arg:a, end time :"+System.currentTimeMillis());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        threa2.start();

    }
}
