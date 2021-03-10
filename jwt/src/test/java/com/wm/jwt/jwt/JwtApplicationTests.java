package com.wm.jwt.jwt;

import groovy.util.logging.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
class JwtApplicationTests {

    @Test
    void contextLoads() {
    }

    private static final Log logger = LogFactory.getLog(JwtApplicationTests.class);

    @Test
    void testPasswordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.printf("编码后的密码：%s,密码是否正确：%s",encode,encoder.matches("123456", encode));
    }
}
