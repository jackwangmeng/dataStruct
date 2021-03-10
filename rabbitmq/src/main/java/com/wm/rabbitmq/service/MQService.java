package com.wm.rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wm
 * @Package service
 * @date 2021/3/10 17:05
 */
@Service
public class MQService {

    @RabbitListener(queues = "fanout.queue")
    public void receive(Message message) {
        System.out.println("收到消息：" + new String(message.getBody()));
    }
}
