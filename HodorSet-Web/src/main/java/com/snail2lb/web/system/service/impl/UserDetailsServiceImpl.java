package com.snail2lb.web.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.snail2lb.web.commons.api.User;
import com.snail2lb.web.system.service.UserService;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-23 11:49
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectByUsername(username);
        if(null == user){
            throw new UsernameNotFoundException("账号不存在");
        }

        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
