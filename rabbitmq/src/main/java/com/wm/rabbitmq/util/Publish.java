package com.wm.rabbitmq.util;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;


public class Publish {

    @SneakyThrows
    public static void publicMessage(Channel channel, byte[] message) {
        //实例化消息服务组件
        String exchangeName = "exchangeName";
        String queueName = "queueName";
        String binding = "binding";
        String routingKey = binding;

        //交换器持久化，自动删除
        boolean durable = true, autoDelete = false;
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT,
                durable, autoDelete, null);

        //独占队列
        boolean exclusive = false;
        channel.queueDeclare(queueName, durable, exclusive, autoDelete, null);
        //交换器/队列绑定
        channel.queueBind(queueName, exchangeName, binding);
        //发送生产信息
        channel.basicPublish(exchangeName, routingKey, null, message);
    }
}
