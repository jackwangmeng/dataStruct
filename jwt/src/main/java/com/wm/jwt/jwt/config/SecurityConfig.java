package com.wm.jwt.jwt.config;

import com.wm.jwt.jwt.service.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wm
 * @Package com.wm.jwt.jwt.config
 * @date 2021/3/9 17:52
 */
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return (PasswordEncoder) new BCryptPasswordEncoder();
    }
}

