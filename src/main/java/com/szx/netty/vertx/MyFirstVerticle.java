package com.szx.netty.vertx;

import io.vertx.core.AbstractVerticle;

public class MyFirstVerticle extends AbstractVerticle {
    public void start(){
        vertx.createHttpServer().requestHandler(req -> {
           req.response().putHeader("content-type","text/plain").end("hello world vertx");
        }).listen(8080);
    }
}
