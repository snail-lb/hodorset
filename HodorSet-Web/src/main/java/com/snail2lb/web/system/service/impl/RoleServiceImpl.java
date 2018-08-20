package com.snail2lb.web.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.common.exception.ParameterException;
import com.snail2lb.web.common.utils.UUIDUtil;
import com.snail2lb.web.commons.api.Role;
import com.snail2lb.web.system.dao.RoleAuthoritiesMapper;
import com.snail2lb.web.system.dao.RoleMapper;
import com.snail2lb.web.system.dao.UserRoleMapper;
import com.snail2lb.web.system.model.RoleAuthoritiesPO;
import com.snail2lb.web.system.model.RolePO;
import com.snail2lb.web.system.model.UserRolePO;
import com.snail2lb.web.system.service.RoleService;
import tk.mybatis.mapper.entity.Example;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleAuthoritiesMapper roleAuthoritiesMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public String[] getRoleIds(String userId) {
        UserRolePO po = new UserRolePO();
        po.setUserId(userId);
        List<UserRolePO> userRoles = userRoleMapper.select(po);
        String[] roleIds = new String[userRoles.size()];
        for (int i = 0; i < userRoles.size(); i++) {
            roleIds[i] = userRoles.get(i).getRoleId();
        }
        return roleIds;
    }

    @Override
    public List<Role> list(boolean showDelete) {
        Example example = new Example(RolePO.class);
        if (!showDelete) {
            example.createCriteria().andEqualTo("is_delete",0);
        }
        example.setOrderByClause("create_time");

        List<RolePO> pos =  roleMapper.selectByExample(example);
        List<Role> result = new ArrayList<>();
        if(!CollectionUtils.isEmpty(pos)){
            pos.stream().forEach(po -> result.add(po2Vo(po)));
        }
        return result;
    }

    @Override
    public boolean add(Role role) {
        role.setRoleId(UUIDUtil.randomUUID8());
        role.setCreateTime(new Date());
        return roleMapper.insert(vo2Po(role)) > 0;
    }

    @Override
    public boolean update(Role role) {
        RolePO po = vo2Po(role);

        if(po.getRoleId() ==null){
            throw new ParameterException("修改Role需要设置roleId值");
        }
        return roleMapper.updateByPrimaryKeySelective(po) > 0;
    }

    @Override
    public boolean updateState(String roleId, int isDelete) {
        if (isDelete != 0 && isDelete != 1) {
            throw new ParameterException("isDelete值需要在[0,1]中");
        }
        Role role = new Role();
        role.setRoleId(roleId);
        role.setIsDelete(isDelete);
        boolean rs = update(role);
        if (rs) {  //删除角色的权限
            RoleAuthoritiesPO po = new RoleAuthoritiesPO();
            po.setRoleId(roleId);
            roleAuthoritiesMapper.delete(po);
        }
        return rs;
    }

    @Override
    public Role getById(String roleId) {
        return po2Vo(roleMapper.selectByPrimaryKey(roleId));
    }

    @Override
    public boolean delete(String roleId) {
        return roleMapper.deleteByPrimaryKey(roleId) > 0;
    }

    private RolePO vo2Po(Role vo){
        return BeanCopyUtil.copyTo(vo, new RolePO());
    }

    private Role po2Vo(RolePO po){
        return BeanCopyUtil.copyTo(po, new Role());
    }
}
