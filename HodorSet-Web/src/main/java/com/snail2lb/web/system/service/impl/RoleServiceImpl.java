package com.snail2lb.web.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.commons.api.Authorities;
import com.snail2lb.web.commons.api.Role;
import com.snail2lb.web.system.dao.RoleMapper;
import com.snail2lb.web.system.po.RolePO;
import com.snail2lb.web.system.service.AuthoritiesService;
import com.snail2lb.web.system.service.RoleService;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthoritiesService authoritiesService;

    @Override
    public boolean insert(Role role) {
        if(null == role){
            return false;
        }
        RolePO po = vo2Po(role);
        return roleMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean delete(Role role) {
        if(null == role){
            return false;
        }
        RolePO po = vo2Po(role);
        return roleMapper.delete(po) > 0;
    }

    @Override
    public boolean deleteById(Object id) {
        if(null == id){
            return false;
        }
        return roleMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean update(Role role) {
        if(null == role){
            return false;
        }
        if(null == role.getId()){
            return false;
        }
        RolePO po = vo2Po(role);
        return roleMapper.updateByPrimaryKeySelective(po) > 0;
    }

    @Override
    public Role selectById(Object id) {
        if(null == id){
            return null;
        }
        RolePO po = roleMapper.selectByPrimaryKey(id);
        Role vo = po2Vo(po);
        selectOtherMessage(vo);
        return vo;
    }
    
    @Override
    public Page<Role> selectByConditions(Role role, Integer pageNum, Integer pageSize) {
        Page<Role> page = PageHelper.startPage(pageNum, pageSize, true);
        if(pageNum == -1 && pageSize == -1){
            page.setPageSizeZero(true);
            page.setPageSize(0);
        }
        
        RolePO conditions = vo2Po(role);
        List<RolePO> poList =  roleMapper.select(conditions);
        List<Role> voList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(poList)){
            poList.forEach(po -> {
                Role vo = po2Vo(po);
                selectOtherMessage(vo);
                voList.add(vo);
            });
        }
        page.clear();
        page.addAll(voList);
        return page;
    }

    @Override
    public Role selectByRoleCode(String roleCode) {
        if(StringUtils.isBlank(roleCode)){
            return null;
        }
        RolePO roleConditions = new RolePO();
        roleConditions.setRoleCode(roleCode);
        RolePO po = roleMapper.selectOne(roleConditions);
        Role vo = po2Vo(po);
        selectOtherMessage(vo);
        return vo;
    }

    private void selectOtherMessage(Role role){
        if(null == role){
            return;
        }
        if(StringUtils.isNotBlank(role.getRoleCode())) {
            List<Authorities> authoritiesList = authoritiesService.selectByRoleCode(role.getRoleCode());
            role.setAuthorities(authoritiesList);
        }
    }

    private RolePO vo2Po(Role vo){
        return BeanCopyUtil.copyTo(vo, new RolePO());
    }

    private Role po2Vo(RolePO po){
        return BeanCopyUtil.copyTo(po, new Role());
    }
    
}