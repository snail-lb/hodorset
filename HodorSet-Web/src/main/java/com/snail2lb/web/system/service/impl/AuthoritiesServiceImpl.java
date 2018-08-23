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
import com.snail2lb.web.system.dao.AuthoritiesMapper;
import com.snail2lb.web.system.po.AuthoritiesPO;
import com.snail2lb.web.system.service.AuthoritiesService;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:46
 */
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
    
    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Override
    public boolean insert(Authorities authorities) {
        if(null == authorities){
            return false;
        }
        AuthoritiesPO po = vo2Po(authorities);
        return authoritiesMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean delete(Authorities authorities) {
        if(null == authorities){
            return false;
        }
        AuthoritiesPO po = vo2Po(authorities);
        return authoritiesMapper.delete(po) > 0;
    }

    @Override
    public boolean deleteById(Object id) {
        if(null == id){
            return false;
        }
        return authoritiesMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean update(Authorities authorities) {
        if(null == authorities){
            return false;
        }
        if(null == authorities.getId()){
            return false;
        }
        AuthoritiesPO po = vo2Po(authorities);
        return authoritiesMapper.updateByPrimaryKeySelective(po) > 0;
    }

    @Override
    public Authorities selectById(Object id) {
        if(null == id){
            return null;
        }
        AuthoritiesPO po = authoritiesMapper.selectByPrimaryKey(id);
        return po2Vo(po);
    }
    
    @Override
    public Page<Authorities> selectByConditions(Authorities authorities, Integer pageNum, Integer pageSize) {
        Page<Authorities> page = PageHelper.startPage(pageNum, pageSize, true);
        if(pageNum == -1 && pageSize == -1){
            page.setPageSizeZero(true);
            page.setPageSize(0);
        }
        
        AuthoritiesPO conditions = vo2Po(authorities);
        List<AuthoritiesPO> poList =  authoritiesMapper.select(conditions);
        List<Authorities> voList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(poList)){
            poList.forEach(po -> voList.add(po2Vo(po)));
        }
        page.clear();
        page.addAll(voList);
        return page;
    }

    @Override
    public List<Authorities> selectByRoleCode(String roleCode) {
        if(StringUtils.isBlank(roleCode)){
            return null;
        }
        List<AuthoritiesPO> poList = authoritiesMapper.selectByRoleCode(roleCode);
        List<Authorities> voList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(poList)){
            poList.forEach(po -> voList.add(po2Vo(po)));
        }
        return voList;
    }

    private AuthoritiesPO vo2Po(Authorities vo){
        return BeanCopyUtil.copyTo(vo, new AuthoritiesPO());
    }

    private Authorities po2Vo(AuthoritiesPO po){
        return BeanCopyUtil.copyTo(po, new Authorities());
    }
    
}