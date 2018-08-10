package com.snail2lb.web.system.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.snail2lb.web.commons.api.LoginRecord;
import com.snail2lb.web.system.model.LoginRecordPO;


public interface LoginRecordMapper extends BaseMapper<LoginRecordPO> {

    List<LoginRecordPO> listFull(Page<LoginRecord> page, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("account") String account);
}
