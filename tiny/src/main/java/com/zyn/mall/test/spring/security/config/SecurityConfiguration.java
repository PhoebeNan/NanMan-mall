package com.zyn.mall.test.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhaoyanan
 * @create 2020-02-29-16:32
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests() //authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护。
                    .antMatchers("/product/**").hasRole("USER")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin() //formLogin() 定义当需要用户登录时候，转到的登录页面。
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .withUser("admin1") // 管理员admin1，同时具有"ADMIN","USER"两种角色的权限，可以访问所有资源
                    .password("{noop}admin1")
                    .roles("ADMIN","USER")
                    .and()
                .withUser("user1")
                    .password("{noop}user1")
                    .roles("User");
    }


}
