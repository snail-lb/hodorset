package com.snail2lb.web.echart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.common.exception.BusinessException;
import com.snail2lb.web.echart.api.CustomOption;
import com.snail2lb.web.echart.dao.CustomOptionMapper;
import com.snail2lb.web.echart.model.CustomOptionPO;
import com.snail2lb.web.echart.service.CustomOptionService;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-13 22:22
 */
@Service
public class CustomOptionServiceImpl implements CustomOptionService {

    @Autowired
    private CustomOptionMapper customOptionMapper;

    @Override
    public CustomOption selectById(Integer id) {
        CustomOptionPO customOptionPO = customOptionMapper.selectById(id);
        return po2Vo(customOptionPO);
    }

    @Override
    public PageResult<CustomOption> list() {
        List<CustomOption> customOptions = new ArrayList<>();
        customOptionMapper.selectList(null)
                .forEach(customOptionPO -> customOptions.add(po2Vo(customOptionPO)));
        PageResult<CustomOption> result = new PageResult<>(customOptions);
        return result;
    }

    @Override
    public boolean add(CustomOption customOption) {
        return customOptionMapper.insert(vo2Po(customOption)) > 0;
    }

    @Override
    public boolean update(CustomOption customOption) {
        if(null == customOption.getId()){
            throw new BusinessException("修改数据必须带有id参数");
        }
        return customOptionMapper.updateById(vo2Po(customOption)) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return customOptionMapper.deleteById(id) > 0;
    }

    @Override
    public PageResult<CustomOption> selectByType(String type) {
        List<CustomOption> customOptions = new ArrayList<>();
        customOptionMapper.selectList(new EntityWrapper<CustomOptionPO>().where("type={0}",type))
                .forEach(customOptionPO -> customOptions.add(po2Vo(customOptionPO)));
        PageResult<CustomOption> result = new PageResult<>(customOptions);
        return result;
    }

    @Override
    public PageResult<CustomOption> selectAllPage(Integer pageNum, Integer pageSize) {
        pageNum = null==pageNum?1:pageNum;
        pageSize = null==pageSize?20:pageSize;
        Page<CustomOption> page = new Page<>(pageNum, pageSize);
        List<CustomOption> options = new ArrayList<>();
        customOptionMapper.selectPage(page, null).stream().forEach(po ->options.add(po2Vo(po)));
        PageResult<CustomOption> result = new PageResult<>(options);
        return result;
    }

    private CustomOptionPO vo2Po(CustomOption vo){
        return BeanCopyUtil.copyTo(vo, new CustomOptionPO());
    }

    private CustomOption po2Vo(CustomOptionPO po){
        return BeanCopyUtil.copyTo(po, new CustomOption());
    }
}
