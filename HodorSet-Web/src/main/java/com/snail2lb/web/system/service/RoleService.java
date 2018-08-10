package com.snail2lb.web.system.service;

import java.util.List;

import com.snail2lb.web.commons.api.Role;

public interface RoleService {

    String[] getRoleIds(String userId);

    List<Role> list(boolean showDelete);

    Role getById(String roleId);

    boolean add(Role role);

    boolean update(Role role);

    boolean updateState(String roleId, int isDelete);

    boolean delete(String roleId);

}
