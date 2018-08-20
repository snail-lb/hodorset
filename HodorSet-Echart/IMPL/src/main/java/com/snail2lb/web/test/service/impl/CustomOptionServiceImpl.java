package com.snail2lb.web.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.test.dao.CustomOptionMapper;
import com.snail2lb.web.test.po.CustomOptionPO;
import com.snail2lb.web.test.service.CustomOptionService;
import com.snail2lb.web.test.vo.CustomOption;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-20 19:50:25
 */
@Service
public class CustomOptionServiceImpl implements CustomOptionService {
    
    @Autowired
    private CustomOptionMapper customOptionMapper;

    @Override
    public boolean insert(CustomOption customOption) {
        if(null == customOption){
            return false;
        }
        CustomOptionPO po = vo2Po(customOption);
        return customOptionMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean delete(CustomOption customOption) {
        if(null == customOption){
            return false;
        }
        CustomOptionPO po = vo2Po(customOption);
        return customOptionMapper.delete(po) > 0;
    }

    @Override
    public boolean deleteById(Object id) {
        if(null == id){
            return false;
        }
        return customOptionMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean update(CustomOption customOption) {
        if(null == customOption){
            return false;
        }
        if(null == customOption.getId()){
            return false;
        }
        CustomOptionPO po = vo2Po(customOption);
        return customOptionMapper.updateByPrimaryKeySelective(po) > 0;
    }

    @Override
    public CustomOption selectById(Object id) {
        if(null == id){
            return null;
        }
        CustomOptionPO po = customOptionMapper.selectByPrimaryKey(id);
        return po2Vo(po);
    }
    
    @Override
    public Page<CustomOption> selectByConditions(CustomOption customOption, Integer pageNum, Integer pageSize) {
        Page<CustomOption> page = PageHelper.startPage(pageNum, pageSize, true);
        if(pageNum == -1 && pageSize == -1){
            page.setPageSizeZero(true);
            page.setPageSize(0);
        }
        
        CustomOptionPO conditions = vo2Po(customOption);
        List<CustomOptionPO> poList =  customOptionMapper.select(conditions);
        List<CustomOption> voList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(poList)){
            poList.forEach(po -> voList.add(po2Vo(po)));
        }
        page.clear();
        page.addAll(voList);
        return page;
    }

    private CustomOptionPO vo2Po(CustomOption vo){
        return BeanCopyUtil.copyTo(vo, new CustomOptionPO());
    }

    private CustomOption po2Vo(CustomOptionPO po){
        return BeanCopyUtil.copyTo(po, new CustomOption());
    }
    
}