package com.snail2lb.web.system.service;

import com.github.pagehelper.Page;
import com.snail2lb.web.commons.api.RoleAuthorities;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
public interface RoleAuthoritiesService {

    boolean insert(RoleAuthorities roleAuthorities);

    boolean delete(RoleAuthorities roleAuthorities);

    boolean deleteById(Object id);

    boolean update(RoleAuthorities roleAuthorities);

    RoleAuthorities selectById(Object id);

    Page<RoleAuthorities> selectByConditions(RoleAuthorities roleAuthorities, Integer pageNum, Integer pageSize);

}