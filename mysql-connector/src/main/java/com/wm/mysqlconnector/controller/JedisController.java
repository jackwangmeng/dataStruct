package com.wm.mysqlconnector.controller;

import com.wm.mysqlconnector.config.JedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.controller
 * @date 2021/1/26 11:17
 */
@RestController
public class JedisController {

    @GetMapping("/setnx/{key}/{val}")
    public boolean setnx(@PathVariable String key, @PathVariable String val) {
        JedisConfig jedisConfig = new JedisConfig();
        return jedisConfig.setnx(key, val);
    }
}
