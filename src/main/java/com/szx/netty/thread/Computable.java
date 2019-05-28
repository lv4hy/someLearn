package com.szx.netty.thread;

public interface Computable<A, V> {
    V compute(A arg) throws Exception;
}
