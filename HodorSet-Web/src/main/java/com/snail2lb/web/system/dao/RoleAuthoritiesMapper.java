package com.snail2lb.web.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.snail2lb.web.system.model.RoleAuthorities;

public interface RoleAuthoritiesMapper extends BaseMapper<RoleAuthorities> {

    int deleteTrash();
}