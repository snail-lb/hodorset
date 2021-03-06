package com.snail2lb.web.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.commons.api.Authorities;
import com.snail2lb.web.commons.api.User;
import com.snail2lb.web.system.dao.AuthoritiesMapper;
import com.snail2lb.web.system.dao.UserMapper;
import com.snail2lb.web.system.model.UserPO;


public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AuthoritiesMapper authoritiesMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = po2Vo(userMapper.getByUsername(username));
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        List<String> authoritys = authoritiesMapper.listByUserId(user.getUserId());
        user.setAuthorities(getGrantedAuthority(authoritys));
        return user;
    }

    private List<Authorities> getGrantedAuthority(List<String> authoritys) {
        List<Authorities> grantedAuthorities = new ArrayList<>();
        for (String auth : authoritys) {
            Authorities ga = new Authorities();
            ga.setAuthority(auth);
            grantedAuthorities.add(ga);
        }
        return grantedAuthorities;
    }

    private UserPO vo2Po(User vo){
        return BeanCopyUtil.copyTo(vo, new UserPO());
    }

    private User po2Vo(UserPO po){
        return BeanCopyUtil.copyTo(po, new User());
    }
}
