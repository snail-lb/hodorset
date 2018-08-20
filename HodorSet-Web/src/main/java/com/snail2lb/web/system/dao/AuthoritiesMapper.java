package com.snail2lb.web.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.snail2lb.web.system.model.AuthoritiesPO;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface AuthoritiesMapper extends Mapper<AuthoritiesPO> {

    List<String> listByUserId(String userId);

    List<String> listByRoleId(@Param("roleIds") List<String> roleIds);
}
