package com.snail2lb.web.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.common.beans.BeanCopyUtil;
import com.snail2lb.web.common.utils.UUIDUtil;
import com.snail2lb.web.commons.api.LoginRecord;
import com.snail2lb.web.system.dao.LoginRecordMapper;
import com.snail2lb.web.system.model.LoginRecordPO;
import com.snail2lb.web.system.service.LoginRecordService;

@Service
public class LoginRecordServiceImpl implements LoginRecordService {
    @Autowired
    private LoginRecordMapper loginRecordMapper;

    @Override
    public boolean add(LoginRecord loginRecord) {
        loginRecord.setId(UUIDUtil.randomUUID8());
        loginRecord.setCreateTime(new Date());
        return loginRecordMapper.insert(vo2Po(loginRecord)) > 0;
    }

    @Override
    public PageResult<LoginRecord> list(int pageNum, int pageSize, String startDate, String endDate, String account) {
        Page<LoginRecord> page = new Page<>(pageNum, pageSize);
        List<LoginRecord> loginRecords = new ArrayList<>();
        loginRecordMapper.listFull(page, startDate, endDate, account)
                .stream().forEach(loginRecordPO -> loginRecords.add(po2Vo(loginRecordPO)));
        page.setRecords(loginRecords);
        return new PageResult<>(page.getTotal(), page.getRecords());
    }

    private LoginRecordPO vo2Po(LoginRecord vo){
        return BeanCopyUtil.copyTo(vo, new LoginRecordPO());
    }

    private LoginRecord po2Vo(LoginRecordPO po){
        return BeanCopyUtil.copyTo(po, new LoginRecord());
    }
}