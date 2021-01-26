package com.wm.mysqlconnector.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.commands.JedisCommands;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.config
 * @date 2021/1/26 11:00
 */
@Component
public class JedisConfig {

    int port = 6379;
    String ip = "127.0.0.1";
    int timeout = 10000;
    String password = "!Mh6MS5OPh";
    JedisCommands jedisCommands;

    Jedis jedis = null;
    JedisPool jedisPool ;
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    public JedisConfig() {
        // 初始化jedis
        // 设置配置
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(100);
        jedisPoolConfig.setTestOnBorrow(false);//jedis 第一次启动时，会报错
        jedisPoolConfig.setTestOnReturn(true);
        // 初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig, ip, port,  timeout, password);
        //
        Jedis jedis = jedisPool.getResource();

        jedisCommands = jedis;
    }

    public boolean setnx(String key, String val) {

        try {
            if (jedis == null) {
                return false;
            }
            return jedis.set(key,val).equalsIgnoreCase("ok");
        } catch (Exception e) {

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    public int delnx(String key, String val) {

        try {
            if (jedis == null) {
                return 0;
            }

            StringBuilder sbScript = new StringBuilder();
            sbScript.append("if redis.call('get', '").append(key).append("')").append("=='").append(val).append("'").
                    append("then").
                    append("return redis.call('del','").append(key).append("')").
                    append(" else ").
                    append(" return 0").append("end");

            return Integer.valueOf(jedis.eval(sbScript.toString()).toString());
        } catch (Exception e) {

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }
}
