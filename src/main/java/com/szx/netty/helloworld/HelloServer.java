package com.szx.netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.omg.SendingContext.RunTime;
import org.omg.SendingContext.RunTimeOperations;
import sun.rmi.runtime.RuntimeUtil;

public class HelloServer {

    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors());

    }
}
