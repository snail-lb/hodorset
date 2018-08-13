package com.snail2lb.web.echart.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snail2lb.web.echart.service.EchartModelService;
import io.swagger.annotations.Api;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-13 23:17
 */
@Api(value = "Echart图形管理相关的接口", tags = "model")
@RestController
@RequestMapping("/model")
public class EchartModelController {

    @Autowired
    private EchartModelService echartModelService;
}
