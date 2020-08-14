package com.aaa.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import java.util.Collection;

@Data
public class Customer implements UserDetails {
    @Id
    private Integer cid;
    private String cname;
    private String pwd;
    private Integer sex;
    private Integer isexpired;
    private Integer islocked;
    private Integer isCreExpired;
    private Integer isenable;

    /**
     * 获取的权限
     * @return
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 用户密码
     * @return
     */
    public String getPassword() {
        return this.pwd;
    }

    /**
     * 用户名
     * @return
     */
    public String getUsername() {
        return this.cname;
    }

    /**
     * 账号是否过期
     * @return
     */
    public boolean isAccountNonExpired() {
        return this.isexpired==1;
    }

    /**
     * 账号是否被锁定
     * @return
     */
    public boolean isAccountNonLocked() {
        return this.islocked ==1;
    }

    /**
     * 评审是否过期
     * @return
     */
    public boolean isCredentialsNonExpired() {
        return this.isCreExpired == 1;
    }

    /**
     * 账号是否可用
     * @return
     */
    public boolean isEnabled() {
        return this.isenable==1;
    }
}
