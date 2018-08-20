package com.snail2lb.web.system.service;


import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.commons.api.LoginRecord;

public interface LoginRecordService {

    boolean add(LoginRecord loginRecord);

    PageResult<LoginRecord> list(Integer pageNum, Integer pageSize, String startDate, String endDate, String account);
}
