package com.wm.mysqlconnector.config;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.config
 * @date 2021/1/22 15:06
 */
@Configuration
public class RabbitConfig {

    private final Logger logger = (Logger) LoggerFactory.getLogger(RabbitConfig.class);
    
}
