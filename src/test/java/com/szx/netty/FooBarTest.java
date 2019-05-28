package com.szx.netty;

import com.szx.netty.basic.Bar;
import org.junit.Test;

public class FooBarTest {

    @Test
    public void fooBarTest(){
        Bar bar = new Bar();
        System.out.println(bar.getValue());
    }
}
