package com.szx.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;

public class NettyServer {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap sbt = new ServerBootstrap();
        sbt.group(bossGroup, workGroup);
        sbt.handler(new LoggingHandler());
        sbt.channel(NioServerSocketChannel.class);
        sbt.option(ChannelOption.SO_BACKLOG, 1024);
        sbt.option(ChannelOption.SO_SNDBUF, 32*1024);
        sbt.option(ChannelOption.SO_RCVBUF, 32*1024);
        sbt.option(ChannelOption.SO_KEEPALIVE, true);
        sbt.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringEncoder()).addLast(new StringDecoder());
            }
        });

        ChannelFuture f = sbt.bind(8090).sync();
        f.channel().closeFuture().sync();

        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }

}
