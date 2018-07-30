package com.snail2lb.web.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.common.utils.UUIDUtil;
import com.snail2lb.web.system.dao.LoginRecordMapper;
import com.snail2lb.web.system.model.LoginRecord;
import com.snail2lb.web.system.service.LoginRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginRecordServiceImpl implements LoginRecordService {
    @Autowired
    private LoginRecordMapper loginRecordMapper;

    @Override
    public boolean add(LoginRecord loginRecord) {
        loginRecord.setId(UUIDUtil.randomUUID8());
        loginRecord.setCreateTime(new Date());
        return loginRecordMapper.insert(loginRecord) > 0;
    }

    @Override
    public PageResult<LoginRecord> list(int pageNum, int pageSize, String startDate, String endDate, String account) {
        Page<LoginRecord> page = new Page<>(pageNum, pageSize);
        page.setRecords(loginRecordMapper.listFull(page, startDate, endDate, account));
        return new PageResult<>(page.getTotal(), page.getRecords());
    }
}