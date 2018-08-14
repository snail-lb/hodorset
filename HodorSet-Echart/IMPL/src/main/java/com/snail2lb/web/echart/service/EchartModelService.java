package com.snail2lb.web.echart.service;

import java.util.List;

import com.snail2lb.web.echart.api.EchartModel;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-13 22:18
 */
public interface EchartModelService {

    EchartModel selectById(Integer id);

    List<EchartModel> selectAll();

    List<EchartModel> slectByGroup(String group);

    boolean add(EchartModel echartModel);

    boolean update(EchartModel echartModel);

    boolean deleteById(Integer id);
}
