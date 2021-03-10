package com.wm.jwt.jwt.service;

/**
 * @author wm
 * @Package com.wm.jwt.jwt.service
 * @date 2021/3/9 11:25
 */
public class MutableUser {
    private String password;

    private final UserDetails delegate;

    MutableUser(UserDetails user) {
        this.delegate = user;
        this.password = user.getPassword();
    }

}
