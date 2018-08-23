package com.snail2lb.web.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.commons.api.Role;
import com.snail2lb.web.commons.api.User;
import com.snail2lb.web.system.dao.UserMapper;
import com.snail2lb.web.system.po.UserPO;
import com.snail2lb.web.system.service.RoleService;
import com.snail2lb.web.system.service.UserService;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean insert(User user) {
        if(null == user){
            return false;
        }
        UserPO po = vo2Po(user);
        String password = passwordEncoder.encode(user.getPassword());
        po.setPassword(password);
        return userMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean delete(User user) {
        if(null == user){
            return false;
        }
        UserPO po = vo2Po(user);
        return userMapper.delete(po) > 0;
    }

    @Override
    public boolean deleteById(Object id) {
        if(null == id){
            return false;
        }
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean update(User user) {
        if(null == user){
            return false;
        }
        if(null == user.getId()){
            return false;
        }
        UserPO po = vo2Po(user);
        return userMapper.updateByPrimaryKeySelective(po) > 0;
    }

    @Override
    public User selectById(Object id) {
        if(null == id){
            return null;
        }
        UserPO po = userMapper.selectByPrimaryKey(id);
        User user = po2Vo(po);
        selectOtherMessage(user);
        return user;
    }
    
    @Override
    public Page<User> selectByConditions(User user, Integer pageNum, Integer pageSize) {
        Page<User> page = PageHelper.startPage(pageNum, pageSize, true);
        if(pageNum == -1 && pageSize == -1){
            page.setPageSizeZero(true);
            page.setPageSize(0);
        }
        
        UserPO conditions = vo2Po(user);
        List<UserPO> poList =  userMapper.select(conditions);
        List<User> voList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(poList)){
            poList.forEach(po -> {
                User vo = po2Vo(po);
                selectOtherMessage(vo);
                voList.add(vo);
            });
        }
        page.clear();
        page.addAll(voList);
        return page;
    }

    @Override
    public User selectByUsername(String username) {
        if(null == username){
            return null;
        }
        UserPO conditions = new UserPO();
        conditions.setUsername(username);
        UserPO po = userMapper.selectOne(conditions);
        User user = po2Vo(po);
        selectOtherMessage(user);
        return user;
    }

    private void selectOtherMessage(User user){
        if(null == user){
            return;
        }
        if(StringUtils.isNotBlank(user.getRoleCode())) {
            Role role = roleService.selectByRoleCode(user.getRoleCode());
            user.setRole(role);
        }
    }

    private UserPO vo2Po(User vo){
        return BeanCopyUtil.copyTo(vo, new UserPO());
    }

    private User po2Vo(UserPO po){
        return BeanCopyUtil.copyTo(po, new User());
    }
    
}