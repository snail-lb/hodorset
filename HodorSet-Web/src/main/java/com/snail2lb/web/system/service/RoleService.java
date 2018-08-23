package com.snail2lb.web.system.service;

import com.github.pagehelper.Page;
import com.snail2lb.web.commons.api.Role;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
public interface RoleService {

    boolean insert(Role role);

    boolean delete(Role role);

    boolean deleteById(Object id);

    boolean update(Role role);

    Role selectById(Object id);

    Page<Role> selectByConditions(Role role, Integer pageNum, Integer pageSize);

    Role selectByRoleCode(String roleCode);

}