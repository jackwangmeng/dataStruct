package com.wm.rabbitmq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;


public class ChannelUtils {

    @SneakyThrows
    public static Channel createChannel() {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ服务应用信息
        //服务默认端口5672/，安装启动后会默认有个账号guest
        factory.setHost("RabbitMQ应用服务安装IP地址");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        //实例化连接
        Connection connection = factory.newConnection();

        //获取信道实例
        Channel channel = connection.createChannel();
        return channel;
    }
}
