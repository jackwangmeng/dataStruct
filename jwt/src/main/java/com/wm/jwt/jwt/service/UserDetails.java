package com.wm.jwt.jwt.service;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author wm
 * @Package com.wm.jwt.jwt.service
 * @date 2021/3/9 11:01
 */
public interface UserDetails extends Serializable {

    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getUsername();

    /**
     * 用户的帐户是否已过期。过期的帐户无法通过身份验证
     */
    boolean isAccountNonExpired();

    /**
     * 用户是锁定还是解锁。锁定的用户无法通过身份验证
     * @return 没有锁定返回true
     */
    boolean isAccountNonLocked();

    /**
     * 用户的凭据（密码）是否已过期。过期的凭据会阻止身份验证
     */
    boolean isCredentialsNonExpired();

    /**
     * 启用还是禁用用户。禁用的用户无法通过身份验证
     */
    boolean isEnabled();
}
