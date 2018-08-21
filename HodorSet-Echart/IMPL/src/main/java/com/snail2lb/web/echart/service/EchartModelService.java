package com.snail2lb.web.echart.service;

import com.github.pagehelper.Page;
import com.snail2lb.web.echart.api.vo.EchartModel;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-21 18:33:22
 */
public interface EchartModelService {

    boolean insert(EchartModel echartModel);

    boolean delete(EchartModel echartModel);

    boolean deleteById(Object id);

    boolean update(EchartModel echartModel);

    EchartModel selectById(Object id);

    Page<EchartModel> selectByConditions(EchartModel echartModel, Integer pageNum, Integer pageSize);

}