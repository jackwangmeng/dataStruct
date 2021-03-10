package com.wm.jwt.jwt.service;

/**
 * @author wm
 * @Package com.wm.jwt.jwt.service
 * @date 2021/3/9 11:41
 */
public interface PasswordEncoder {

    /**
     * 编码原始密码。通常，良好的编码算法将SHA-1或更大的哈希值与8字节或更大的随机生成的盐结合使用
     */
    String encode(CharSequence rawPassword);

    /**
     * 验证从存储中获取的编码密码，也对提交的原始密码进行编码。如果密码匹配，则返回true；否则，返回false。存储的      * 密码本身不会被解码。
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);

    /**
     * 如果需要再次对编码后的密码进行编码以提高安全性，则返回true，否则返回false。默认实现始终返回false
     */
    default boolean upgradeEncoding(String encodedPassword) {
        return false;
    }

}

