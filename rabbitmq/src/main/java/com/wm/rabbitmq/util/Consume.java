package com.wm.rabbitmq.util;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;

import java.io.IOException;

public class Consume {

    public static void consumeMessage(Channel channel) throws IOException {
        String queueName = "queueName";
        String consumerTag = "consumerTag";
        // 消息消费实例
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery (String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                // 处理消息
            }
        };
        // 自动消息确认
        boolean autoAck = true;
        channel.basicConsume(queueName,autoAck,consumerTag,consumer);
    }
    @SneakyThrows
    public static void destroyConnection(Connection connection, Channel channel){
        channel.close();
        connection.close();
    }

}
