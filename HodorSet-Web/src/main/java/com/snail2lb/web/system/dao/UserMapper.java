package com.snail2lb.web.system.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.snail2lb.web.commons.api.User;

public interface UserMapper extends BaseMapper<User> {

    User getByUsername(String username);
}
