package com.wm.mysqlconnector.controller;

import com.wm.mysqlconnector.entity.User;
import com.wm.mysqlconnector.service.UserService;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Serializable;


/**
 * @author wm
 * @Package com.wm.mysqlconnector.controller
 * @date 2021/1/19 10:02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;
    @Autowired
    private UserService userService;
    @RequestMapping("/test")
    public void test() {
        redisCacheTemplate.opsForValue().set("userkey", new User(1, "张胜男", 25));
        User user = (User) redisCacheTemplate.opsForValue().get("userkey");
        logger.info("当前获取对象：{}", user.toString());
    }

    @RequestMapping("/add")
    public void add() {
        User user = userService.save(new User(4, "李现", 30));
        logger.info("添加的用户信息：{}", user.toString());
    }

    @RequestMapping("/delete")
    public void delete() {
        userService.delete(4);
    }

    @RequestMapping("/get/{id}")
    public void get(@PathVariable("id") String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            throw new Exception("id 为空");
        }
        Integer id = Integer.parseInt(userId);
        User user = userService.get(id);
        logger.info("获取用户信息：{}", user.toString());
    }

//    @SneakyThrows
//    public static Channel createChannel() {
//        //创建连接工厂
//        ConnectionFactory factory = new ConnectionFactory();
//        //设置RabbitMQ服务应用信息
//        //服务默认端口5672安装启动启动
//        factory.setHost("localhost");
//        factory.setPort(5672);
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//        //实例化连接
//        Connection connection = factory.newConnection();
//        //获取信道实例
//        Channel channel = connection.createChannel();
//        return channel;
//    }

    /*@SneakyThrows
    public static void publishMessage(Channel channel, byte[] message) throws IOException {
        //实例化消息服务组价
        String exchangeName = "exchangeName";
        String queueName = "queueName";
        String binding = "binding";
        String routingKey = binding;

        //交换器持久化、自动删除
        boolean durable = true, autoDelete = false;
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT, durable, autoDelete, null);
        //交换器、队列绑定
        channel.queueBind(queueName, exchangeName, binding);
        //发送生产消息
        channel.basicPublish(exchangeName, routingKey, null, message);
    }

    @SneakyThrows
    public static void consumeMessage(Channel channel) throws IOException {
        String queueName = "queueName";
        String consumerTag = "consumerTag";

        //消息消费实例
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
            }
        };
        //自动消息确认
        boolean autoAck = true;
        channel.basicConsume(queueName, autoAck, consumerTag, consumer);
    }
    @SneakyThrows
    public static void destroyConnection(Connection connection, Channel channel) {
        channel.close();
        connection.close();
    }*/

}
