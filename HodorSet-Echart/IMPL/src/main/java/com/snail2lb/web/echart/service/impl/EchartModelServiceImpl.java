package com.snail2lb.web.echart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.common.exception.BusinessException;
import com.snail2lb.web.echart.api.EchartModel;
import com.snail2lb.web.echart.dao.EchartModelMapper;
import com.snail2lb.web.echart.model.EchartModelPO;
import com.snail2lb.web.echart.service.EchartModelService;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-13 22:23
 */
@Service
public class EchartModelServiceImpl implements EchartModelService {

    @Autowired
    private EchartModelMapper echartModelMapper;

    @Override
    public EchartModel selectById(Integer id) {
        return po2Vo(echartModelMapper.selectById(id));
    }

    @Override
    public List<EchartModel> selectAll() {
        List<EchartModel> echartModels = new ArrayList<>();
        echartModelMapper.selectList(null).forEach(echartModelPO -> echartModels.add(po2Vo(echartModelPO)));
        return echartModels;
    }

    @Override
    public List<EchartModel> slectByGroup(String group) {
        List<EchartModel> echartModels = new ArrayList<>();
        Wrapper<EchartModelPO> wrapper = new EntityWrapper<EchartModelPO>();
        wrapper.eq("`group`", group);
        echartModelMapper.selectList(wrapper)
                .forEach(echartModelPO -> echartModels.add(po2Vo(echartModelPO)));
        return echartModels;
    }

    @Override
    public boolean add(EchartModel echartModel) {
        setDefaultValue(echartModel);
        return echartModelMapper.insert(vo2Po(echartModel))>0;
    }

    @Override
    public boolean update(EchartModel echartModel) {
        if(null == echartModel.getId()){
            throw new BusinessException("修改数据必须带有id参数");
        }
        setDefaultValue(echartModel);

        return echartModelMapper.updateById(vo2Po(echartModel)) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return echartModelMapper.deleteById(id) > 0;
    }

    private void setDefaultValue(EchartModel echartModel){
        if(null == echartModel.getInterval()){
            echartModel.setInterval(10 * 60 * 1000);
        }
        if(null == echartModel.getLayuiColMd()){
            echartModel.setLayuiColMd(4);
        }
        if(null == echartModel.getHeight()){
            echartModel.setHeight(400);
        }
    }

    private EchartModelPO vo2Po(EchartModel vo){
        return BeanCopyUtil.copyTo(vo, new EchartModelPO());
    }

    private EchartModel po2Vo(EchartModelPO po){
        return BeanCopyUtil.copyTo(po, new EchartModel());
    }
}
