package com.snail2lb.web.echart.service;

import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.echart.api.CustomOption;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-13 22:18
 */
public interface CustomOptionService {

    CustomOption selectById(Integer id);

    PageResult<CustomOption> list();

    boolean add(CustomOption customOption);

    boolean update(CustomOption customOption);

    boolean deleteById(Integer id);

    PageResult<CustomOption> selectByType(String type);

    PageResult<CustomOption> selectAllPage(Integer pageNum, Integer pageSize);
}
