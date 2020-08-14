package com.aaa.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordConfig implements PasswordEncoder {

    /**
     * 编码
     * @param charSequence 表单提交的密码
     * @return
     */
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    /**
     * 验证表单提交的密码和用户真实的密码是否一致
     * @param charSequence 表单提交的密码
     * @param s 用户真实的密码
     * @return
     */
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}
