package com.snail2lb.web.system.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.snail2lb.web.system.model.LoginRecordPO;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface LoginRecordMapper extends Mapper<LoginRecordPO> {

    List<LoginRecordPO> listFull(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("account") String account);
}
