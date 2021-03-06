package com.snail2lb.web.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.common.utils.UUIDUtil;
import com.snail2lb.web.commons.api.Authorities;
import com.snail2lb.web.commons.api.RoleAuthorities;
import com.snail2lb.web.system.dao.AuthoritiesMapper;
import com.snail2lb.web.system.dao.RoleAuthoritiesMapper;
import com.snail2lb.web.system.model.AuthoritiesPO;
import com.snail2lb.web.system.model.RoleAuthoritiesPO;
import com.snail2lb.web.system.service.AuthoritiesService;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
    @Autowired
    private AuthoritiesMapper authoritiesMapper;
    @Autowired
    private RoleAuthoritiesMapper roleAuthoritiesMapper;

    @Override
    public List<String> listByUserId(String userId) {
        return authoritiesMapper.listByUserId(userId);
    }

    @Override
    public List<Authorities> list() {
        List<Authorities> authoritiesList = new ArrayList<>();
        authoritiesMapper.selectAll().stream().forEach(po -> authoritiesList.add(po2Vo(po)));
        return authoritiesList;
    }

    @Override
    public List<String> listByRoleId(List<String> roleIds) {
        if (roleIds == null || roleIds.size() == 0) {
            return new ArrayList<>();
        }
        return authoritiesMapper.listByRoleId(roleIds);
    }

    @Override
    public List<String> listByRoleId(String roleId) {
        List<String> roleIds = new ArrayList<>();
        if (roleId != null && !roleId.trim().isEmpty()) {
            roleIds.add(roleId);
        }
        return listByRoleId(roleIds);
    }

    @Override
    public boolean add(Authorities authorities) {
        authorities.setCreateTime(new Date());
        return authoritiesMapper.insert(vo2Po(authorities)) > 0;
    }

    @Override
    public boolean add(List<Authorities> authorities) {
        authoritiesMapper.delete(null);
        for (Authorities one : authorities) {
            one.setCreateTime(new Date());
            authoritiesMapper.insert(vo2Po(one));
        }
        roleAuthoritiesMapper.deleteTrash();
        return true;
    }

    @Override
    public boolean addRoleAuth(String roleId, String authId) {
        RoleAuthorities roleAuthorities = new RoleAuthorities();
        roleAuthorities.setId(UUIDUtil.randomUUID8());
        roleAuthorities.setRoleId(roleId);
        roleAuthorities.setAuthority(authId);
        roleAuthorities.setCreateTime(new Date());
        RoleAuthoritiesPO po = BeanCopyUtil.copyTo(roleAuthorities, new RoleAuthoritiesPO());
        return roleAuthoritiesMapper.insert(po) > 0;
    }

    @Override
    public boolean deleteRoleAuth(String roleId, String authId) {
        RoleAuthoritiesPO po = new RoleAuthoritiesPO();
        po.setRoleId(roleId);
        po.setAuthority(authId);
        return roleAuthoritiesMapper.delete(po)>0;
    }

    private AuthoritiesPO vo2Po(Authorities vo){
        return BeanCopyUtil.copyTo(vo, new AuthoritiesPO());
    }

    private Authorities po2Vo(AuthoritiesPO po){
        return BeanCopyUtil.copyTo(po, new Authorities());
    }
}
