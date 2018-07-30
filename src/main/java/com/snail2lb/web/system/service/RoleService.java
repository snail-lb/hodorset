package com.snail2lb.web.system.service;

import com.snail2lb.web.system.model.Role;

import java.util.List;

public interface RoleService {

    String[] getRoleIds(String userId);

    List<Role> list(boolean showDelete);

    Role getById(String roleId);

    boolean add(Role role);

    boolean update(Role role);

    boolean updateState(String roleId, int isDelete);

    boolean delete(String roleId);

}
