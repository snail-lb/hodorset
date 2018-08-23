package com.snail2lb.web.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.snail2lb.web.system.dao.RoleAuthoritiesMapper;
import com.snail2lb.web.system.po.RoleAuthoritiesPO;
import com.snail2lb.web.system.service.RoleAuthoritiesService;
import com.snail2lb.web.commons.api.RoleAuthorities;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.snail2lb.web.common.beans.BeanCopyUtil;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
@Service
public class RoleAuthoritiesServiceImpl implements RoleAuthoritiesService {
    
    @Autowired
    private RoleAuthoritiesMapper roleAuthoritiesMapper;

    @Override
    public boolean insert(RoleAuthorities roleAuthorities) {
        if(null == roleAuthorities){
            return false;
        }
        RoleAuthoritiesPO po = vo2Po(roleAuthorities);
        return roleAuthoritiesMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean delete(RoleAuthorities roleAuthorities) {
        if(null == roleAuthorities){
            return false;
        }
        RoleAuthoritiesPO po = vo2Po(roleAuthorities);
        return roleAuthoritiesMapper.delete(po) > 0;
    }

    @Override
    public boolean deleteById(Object id) {
        if(null == id){
            return false;
        }
        return roleAuthoritiesMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean update(RoleAuthorities roleAuthorities) {
        if(null == roleAuthorities){
            return false;
        }
        if(null == roleAuthorities.getId()){
            return false;
        }
        RoleAuthoritiesPO po = vo2Po(roleAuthorities);
        return roleAuthoritiesMapper.updateByPrimaryKeySelective(po) > 0;
    }

    @Override
    public RoleAuthorities selectById(Object id) {
        if(null == id){
            return null;
        }
        RoleAuthoritiesPO po = roleAuthoritiesMapper.selectByPrimaryKey(id);
        return po2Vo(po);
    }
    
    @Override
    public Page<RoleAuthorities> selectByConditions(RoleAuthorities roleAuthorities, Integer pageNum, Integer pageSize) {
        Page<RoleAuthorities> page = PageHelper.startPage(pageNum, pageSize, true);
        if(pageNum == -1 && pageSize == -1){
            page.setPageSizeZero(true);
            page.setPageSize(0);
        }
        
        RoleAuthoritiesPO conditions = vo2Po(roleAuthorities);
        List<RoleAuthoritiesPO> poList =  roleAuthoritiesMapper.select(conditions);
        List<RoleAuthorities> voList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(poList)){
            poList.forEach(po -> voList.add(po2Vo(po)));
        }
        page.clear();
        page.addAll(voList);
        return page;
    }

    private RoleAuthoritiesPO vo2Po(RoleAuthorities vo){
        return BeanCopyUtil.copyTo(vo, new RoleAuthoritiesPO());
    }

    private RoleAuthorities po2Vo(RoleAuthoritiesPO po){
        return BeanCopyUtil.copyTo(po, new RoleAuthorities());
    }
    
}