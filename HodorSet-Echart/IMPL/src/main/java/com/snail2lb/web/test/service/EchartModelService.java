package com.snail2lb.web.test.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.snail2lb.web.test.vo.EchartModel;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-20 19:50:24
 */
public interface EchartModelService {

    boolean insert(EchartModel echartModel);

    boolean delete(EchartModel echartModel);

    boolean deleteById(Object id);

    boolean update(EchartModel echartModel);

    EchartModel selectById(Object id);

    Page<EchartModel> selectByConditions(EchartModel echartModel, Integer pageNum, Integer pageSize);

}