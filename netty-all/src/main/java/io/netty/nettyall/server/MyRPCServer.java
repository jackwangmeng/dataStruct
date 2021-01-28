package io.netty.nettyall.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author wm
 * @Package io.netty.nettyall.server
 * @date 2021/1/27 14:56
 */
public class MyRPCServer {
    public void start(int port) throws Exception {
        //主线程，不处理任何业务逻辑，只接受客户端的连接请求
        EventLoopGroup boss = new NioEventLoopGroup(1);
        //工作线程，线程数默认是：cup核数 * 2
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            //服务器启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker)  //设置线程组
                .channel(NioServerSocketChannel.class)     //配置server通道
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast("myHandler", (ChannelHandler) new MyChannelHandler());
                    }
                });
            //ByteBuf的分配要设置为非池化，否则不能切换到堆缓冲模式
            serverBootstrap.childOption(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator.DEFAULT);
            ChannelFuture future = serverBootstrap.bind(port).sync();
            System.out.println("服务器启动完成，端口为："+ port);
            //等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
