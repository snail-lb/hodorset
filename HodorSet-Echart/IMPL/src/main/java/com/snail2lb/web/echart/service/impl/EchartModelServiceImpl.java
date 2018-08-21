package com.snail2lb.web.echart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.snail2lb.web.echart.service.EchartModelService;
import com.snail2lb.web.echart.api.vo.EchartModel;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.echart.dao.EchartModelMapper;
import com.snail2lb.web.echart.po.EchartModelPO;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-21 18:33:22
 */
@Service
public class EchartModelServiceImpl implements EchartModelService {
    
    @Autowired
    private EchartModelMapper echartModelMapper;

    @Override
    public boolean insert(EchartModel echartModel) {
        if(null == echartModel){
            return false;
        }
        EchartModelPO po = vo2Po(echartModel);
        return echartModelMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean delete(EchartModel echartModel) {
        if(null == echartModel){
            return false;
        }
        EchartModelPO po = vo2Po(echartModel);
        return echartModelMapper.delete(po) > 0;
    }

    @Override
    public boolean deleteById(Object id) {
        if(null == id){
            return false;
        }
        return echartModelMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean update(EchartModel echartModel) {
        if(null == echartModel){
            return false;
        }
        if(null == echartModel.getId()){
            return false;
        }
        EchartModelPO po = vo2Po(echartModel);
        return echartModelMapper.updateByPrimaryKeySelective(po) > 0;
    }

    @Override
    public EchartModel selectById(Object id) {
        if(null == id){
            return null;
        }
        EchartModelPO po = echartModelMapper.selectByPrimaryKey(id);
        return po2Vo(po);
    }
    
    @Override
    public Page<EchartModel> selectByConditions(EchartModel echartModel, Integer pageNum, Integer pageSize) {
        Page<EchartModel> page = PageHelper.startPage(pageNum, pageSize, true);
        if(pageNum == -1 && pageSize == -1){
            page.setPageSizeZero(true);
            page.setPageSize(0);
        }
        
        EchartModelPO conditions = vo2Po(echartModel);
        List<EchartModelPO> poList =  echartModelMapper.select(conditions);
        List<EchartModel> voList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(poList)){
            poList.forEach(po -> voList.add(po2Vo(po)));
        }
        page.clear();
        page.addAll(voList);
        return page;
    }

    private EchartModelPO vo2Po(EchartModel vo){
        return BeanCopyUtil.copyTo(vo, new EchartModelPO());
    }

    private EchartModel po2Vo(EchartModelPO po){
        return BeanCopyUtil.copyTo(po, new EchartModel());
    }
    
}