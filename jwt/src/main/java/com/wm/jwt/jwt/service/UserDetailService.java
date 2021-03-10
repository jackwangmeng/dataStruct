package com.wm.jwt.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author wm
 * @Package com.wm.jwt.jwt.service
 * @date 2021/3/9 10:58
 */
public interface UserDetailService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
