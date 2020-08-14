package com.aaa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("我进来了");
        //form表单形式进行登录
        http.formLogin()
                //登录页面
                .loginPage("/login.html")
                //form表单提交的路径
                .loginProcessingUrl("/login-check")
                //默认成功路径,登录成功之后跳转的路径,直接访问登录路径时
                .defaultSuccessUrl("/home.html")
                //失败路径
                .failureUrl("/failure")
                //用户名参数
                .usernameParameter("cname")
                //密码参数
                .passwordParameter("pwd")
                //不进行认证
                .permitAll()
                //拼接条件
                .and()
                //授权请求:设置访问请求的处理
                .authorizeRequests()
                .antMatchers("/course.html")
                .permitAll()
                //任意请求
                .anyRequest()
                //进行认证
                .authenticated()
                .and()
                //跨域请求
                .csrf()
                //禁用
                .disable();
    }

    @Resource
    UserConfig userConfig;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("怎么说");
        //身份提供程序
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //密码编码格式：表单传递过来的密码进行加密
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        //用户详细信息：获取用户的真实身份
        daoAuthenticationProvider.setUserDetailsService(userConfig);
        auth.authenticationProvider(daoAuthenticationProvider);
    }
}
