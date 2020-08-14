package com.aaa.security;

import com.aaa.entity.Customer;
import com.aaa.service.CustomerService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserConfig implements UserDetailsService {

    @Resource
    CustomerService customerService;

    /**
     * 通过用户名获取用户信息
     * @param s 表单提交的用户名
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer byCname = customerService.findByCname(s);
        System.out.println(byCname);
        if (byCname == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return byCname;
    }
}
