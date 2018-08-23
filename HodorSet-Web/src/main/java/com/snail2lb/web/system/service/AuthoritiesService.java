package com.snail2lb.web.system.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.snail2lb.web.commons.api.Authorities;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:46
 */
public interface AuthoritiesService {

    boolean insert(Authorities authorities);

    boolean delete(Authorities authorities);

    boolean deleteById(Object id);

    boolean update(Authorities authorities);

    Authorities selectById(Object id);

    Page<Authorities> selectByConditions(Authorities authorities, Integer pageNum, Integer pageSize);

    List<Authorities> selectByRoleCode(String roleCode);
}