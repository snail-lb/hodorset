package com.snail2lb.web.test.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.snail2lb.web.test.vo.CustomOption;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-20 19:50:25
 */
public interface CustomOptionService {

    boolean insert(CustomOption customOption);

    boolean delete(CustomOption customOption);

    boolean deleteById(Object id);

    boolean update(CustomOption customOption);

    CustomOption selectById(Object id);

    Page<CustomOption> selectByConditions(CustomOption customOption, Integer pageNum, Integer pageSize);

}