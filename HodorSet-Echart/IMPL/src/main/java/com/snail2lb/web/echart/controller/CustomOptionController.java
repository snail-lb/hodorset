package com.snail2lb.web.echart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.echart.api.CustomOption;
import com.snail2lb.web.echart.service.CustomOptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-13 23:17
 */
@Api(value = "Echart默认图形管理相关的接口", tags = "CustomOption")
@RestController
@RequestMapping("/option")
public class CustomOptionController {

    @Autowired
    private CustomOptionService customOptionService;

    @ApiOperation(value = "获取指定的表格结构", notes = " 获取指定的表格结构")
    @RequestMapping(value = "/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResult<CustomOption> echart(@PathVariable String type) {
        List<CustomOption> customOptions = customOptionService.selectByType(type);
        return new PageResult<CustomOption>(customOptions);
    }
}
