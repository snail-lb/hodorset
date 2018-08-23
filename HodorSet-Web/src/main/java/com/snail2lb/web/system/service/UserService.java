package com.snail2lb.web.system.service;

import com.github.pagehelper.Page;
import com.snail2lb.web.commons.api.User;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
public interface UserService {

    boolean insert(User user);

    boolean delete(User user);

    boolean deleteById(Object id);

    boolean update(User user);

    User selectById(Object id);

    Page<User> selectByConditions(User user, Integer pageNum, Integer pageSize);

    User selectByUsername(String username);

}