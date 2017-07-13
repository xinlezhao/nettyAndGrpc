package com.xinle.netty.thirdexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by xinle on 6/8/17.
 */
public class MyChatClient {

    public static void main(String[] args) throws Exception {

        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker).channel(NioSocketChannel.class).handler(new MyChatClientInitializer());
            Channel channel = bootstrap.connect("localhost", 8800).sync().channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (;;){
                channel.writeAndFlush(br.readLine() + "\r\n");
            }



        }finally {
            worker.shutdownGracefully();
        }
    }
}
