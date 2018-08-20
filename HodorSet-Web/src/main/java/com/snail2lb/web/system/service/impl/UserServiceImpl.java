package com.snail2lb.web.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.common.exception.BusinessException;
import com.snail2lb.web.common.exception.ParameterException;
import com.snail2lb.web.common.utils.UUIDUtil;
import com.snail2lb.web.commons.api.Role;
import com.snail2lb.web.commons.api.User;
import com.snail2lb.web.commons.api.UserRole;
import com.snail2lb.web.system.dao.RoleMapper;
import com.snail2lb.web.system.dao.UserMapper;
import com.snail2lb.web.system.dao.UserRoleMapper;
import com.snail2lb.web.system.model.UserPO;
import com.snail2lb.web.system.model.UserRolePO;
import com.snail2lb.web.system.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User getByUsername(String username) {
        return po2Vo(userMapper.getByUsername(username));
    }

    @Override
    public PageResult<User> list(int pageNum, int pageSize, boolean showDelete, String column, String value) {
        return null;
        /*Wrapper<UserPO> wrapper = new EntityWrapper<UserPO>();
        if (StringUtil.isNotBlank(column)) {
            wrapper.like(column, value);
        }
        if (!showDelete) {
            wrapper.eq("state", 0);
        }
        Page<User> userPage = new Page<>(pageNum, pageSize);
        List<User> userList = new ArrayList<>();
        userMapper.selectPage(userPage, wrapper).stream().forEach(userPO ->userList.add(po2Vo(userPO)));
        // 查询user的角色
        List<String> userIds = new ArrayList<>();
        for (User one : userList) {
            userIds.add(one.getUserId());
        }
        List<Role> roles = new ArrayList<>();
        roleMapper.selectList(null).stream().forEach(rolePO -> roles.add(BeanCopyUtil.copyTo(rolePO, new Role())));
        List<UserRole> userRoles = new ArrayList<>();
        userRoleMapper.selectList(new EntityWrapper().in("user_id", userIds)).stream().forEach(userRolePO -> userRoles.add(BeanCopyUtil.copyTo(userRolePO, new UserRole())));
        for (User one : userList) {
            List<Role> tempUrs = new ArrayList<>();
            for (UserRole ur : userRoles) {
                if (one.getUserId().equals(ur.getUserId())) {
                    for (Role r : roles) {
                        if (ur.getRoleId().equals(r.getRoleId())) {
                            tempUrs.add(r);
                        }
                    }
                }
            }
            one.setRoles(tempUrs);
        }
        return new PageResult<>(userPage.getTotal(), userList);*/
    }

    @Override
    public boolean add(User user) throws BusinessException {
        String userId = UUIDUtil.randomUUID8();
        user.setUserId(userId);
        String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(finalSecret);
        user.setState(0);
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        try {
            boolean rs = userMapper.insert(vo2Po(user)) > 0;
            if (rs) {
                addUserRole(userId, user.getRoles());
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("账号已经存在");
        }
    }

    @Override
    public boolean update(User user) {
        boolean rs = userMapper.updateByPrimaryKeySelective(vo2Po(user)) > 0;
        if (rs) {
            UserRolePO po = new UserRolePO();
            po.setUserId(user.getUserId());
            userRoleMapper.delete(po);
            addUserRole(user.getUserId(), user.getRoles());
        }
        return rs;
    }

    private void addUserRole(String userId, List<Role> roles) {
        if (roles == null) {
            return;
        }
        for (Role role : roles) {
            UserRole userRole = new UserRole();
            userRole.setId(UUIDUtil.randomUUID8());
            userRole.setUserId(userId);
            userRole.setRoleId(role.getRoleId());
            userRole.setCreateTime(new Date());
            userRoleMapper.insert(BeanCopyUtil.copyTo(userRole, new UserRolePO()));
        }
    }

    @Override
    public boolean updateState(String userId, int state) throws ParameterException {
        if (state != 0 && state != 1) {
            throw new ParameterException("state值需要在[0,1]中");
        }
        User user = new User();
        user.setUserId(userId);
        user.setState(state);
        return userMapper.updateByPrimaryKeySelective(vo2Po(user)) > 0;
    }

    @Override
    public boolean updatePsw(String userId, String password) {
        User user = new User();
        user.setUserId(userId);
        String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode(password);
        user.setPassword(finalSecret);
        return userMapper.updateByPrimaryKeySelective(vo2Po(user)) > 0;
    }

    @Override
    public User getById(String userId) {
        return po2Vo(userMapper.selectByPrimaryKey(userId));
    }

    @Override
    public boolean delete(String userId) {
        return userMapper.deleteByPrimaryKey(userId) > 0;
    }

    private UserPO vo2Po(User vo){
        return BeanCopyUtil.copyTo(vo, new UserPO());
    }

    private User po2Vo(UserPO po){
        return BeanCopyUtil.copyTo(po, new User());
    }
}
