package com.snail2lb.web.system.dao;


import com.snail2lb.web.system.model.RoleAuthoritiesPO;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface RoleAuthoritiesMapper extends Mapper<RoleAuthoritiesPO> {

    int deleteTrash();
}
