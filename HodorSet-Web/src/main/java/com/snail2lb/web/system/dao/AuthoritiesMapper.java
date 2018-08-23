package com.snail2lb.web.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.snail2lb.web.system.po.AuthoritiesPO;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:45
 */
@org.apache.ibatis.annotations.Mapper
public interface AuthoritiesMapper extends Mapper<AuthoritiesPO>{

    @Select("SELECT id,authority_name as authorityName,authority,create_time as createTime FROM `sys_authorities` WHERE authority IN (SELECT authority FROM `sys_role_authorities` WHERE role_code =#{roleCode})")
    List<AuthoritiesPO> selectByRoleCode(@Param("roleCode") String roleCode);
}