package com.snail2lb.web.system.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.snail2lb.web.system.model.UserPO;

public interface UserMapper extends BaseMapper<UserPO> {

    UserPO getByUsername(String username);
}
