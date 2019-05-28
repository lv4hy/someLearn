package com.szx.netty.thread;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger>{
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        System.out.println("start compute expensive arg:"+arg);
        Thread.sleep(5000);

        return new BigInteger("99999");
    }
}
