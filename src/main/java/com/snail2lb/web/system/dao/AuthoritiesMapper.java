package com.snail2lb.web.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.snail2lb.web.system.model.Authorities;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthoritiesMapper extends BaseMapper<Authorities> {

    List<String> listByUserId(String userId);

    List<String> listByRoleId(@Param("roleIds") List<String> roleIds);
}
