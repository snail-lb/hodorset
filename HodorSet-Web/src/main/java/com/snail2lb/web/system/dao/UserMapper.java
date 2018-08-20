package com.snail2lb.web.system.dao;


import com.snail2lb.web.system.model.UserPO;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<UserPO> {

    UserPO getByUsername(String username);
}
