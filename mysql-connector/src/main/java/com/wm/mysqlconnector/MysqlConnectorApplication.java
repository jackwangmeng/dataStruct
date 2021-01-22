package com.wm.mysqlconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MysqlConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlConnectorApplication.class, args);
    }

}
