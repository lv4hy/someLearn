package com.szx.netty.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Client {
    private static class SingleTonHolder {
        static final Client instance = new Client();
    }
    private static Client getInstance(){
        return SingleTonHolder.instance;
    }

    private EventLoopGroup workGroup;
    private ChannelFuture cf;

    private Client(){
        workGroup = new NioEventLoopGroup();
        Bootstrap bs = new Bootstrap();
        bs.channel(NioServerSocketChannel.class);

    }
}
