package com.snail2lb.web.system.service;

import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.common.exception.BusinessException;
import com.snail2lb.web.common.exception.ParameterException;
import com.snail2lb.web.commons.api.User;

public interface UserService {

    User getByUsername(String username);

    PageResult<User> list(int pageNum, int pageSize, boolean showDelete, String searchKey, String searchValue);

    User getById(String userId);

    boolean add(User user) throws BusinessException;

    boolean update(User user);

    boolean updateState(String userId, int state) throws ParameterException;

    boolean updatePsw(String userId, String newPsw);

    boolean delete(String userId);

}
