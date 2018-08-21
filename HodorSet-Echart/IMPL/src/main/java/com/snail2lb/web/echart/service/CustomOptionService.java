package com.snail2lb.web.echart.service;

import com.github.pagehelper.Page;
import com.snail2lb.web.echart.api.vo.CustomOption;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-21 18:33:22
 */
public interface CustomOptionService {

    boolean insert(CustomOption customOption);

    boolean delete(CustomOption customOption);

    boolean deleteById(Object id);

    boolean update(CustomOption customOption);

    CustomOption selectById(Object id);

    Page<CustomOption> selectByConditions(CustomOption customOption, Integer pageNum, Integer pageSize);

}