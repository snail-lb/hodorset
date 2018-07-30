package com.wf.ew.system.service;

import com.wf.ew.system.model.Authorities;

import java.util.List;

public interface AuthoritiesService {

    List<String> listByUserId(String userId);

    List<Authorities> list();

    List<String> listByRoleId(List<String> roleId);

    List<String> listByRoleId(String roleId);

    boolean add(Authorities authorities);

    boolean add(List<Authorities> authorities);

    boolean addRoleAuth(String roleId, String authId);

    boolean deleteRoleAuth(String roleId, String authId);
}
