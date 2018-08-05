package com.snail2lb.web.system.service;

import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.system.model.LoginRecord;

public interface LoginRecordService {

    boolean add(LoginRecord loginRecord);

    PageResult<LoginRecord> list(int pageNum, int pageSize, String startDate, String endDate, String account);
}
