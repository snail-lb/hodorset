package com.snail2lb.web.echart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snail2lb.web.common.beans.BeanCopyUtil;
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
    public List<EchartModel> list() {
        List<EchartModel> echartModels = new ArrayList<>();
        echartModelMapper.selectList(null).forEach(echartModelPO -> echartModels.add(po2Vo(echartModelPO)));
        return echartModels;
    }

    @Override
    public boolean add(EchartModel echartModel) {
        return echartModelMapper.insert(vo2Po(echartModel))>0;
    }

    @Override
    public boolean update(EchartModel echartModel) {
        return echartModelMapper.updateById(vo2Po(echartModel)) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return echartModelMapper.deleteById(id) > 0;
    }

    private EchartModelPO vo2Po(EchartModel vo){
        return BeanCopyUtil.copyTo(vo, new EchartModelPO());
    }

    private EchartModel po2Vo(EchartModelPO po){
        return BeanCopyUtil.copyTo(po, new EchartModel());
    }
}
