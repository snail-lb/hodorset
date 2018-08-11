package com.snail2lb.web.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.snail2lb.web.common.JsonResult;
import com.snail2lb.web.echart.util.bar.BarChartUtil;
import com.snail2lb.web.echart.util.funnel.FunnelChartUtil;
import com.snail2lb.web.echart.util.gauge.GaugeChartUtil;
import com.snail2lb.web.echart.util.line.LineChartUtil;
import com.snail2lb.web.echart.util.pie.PieChartUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-08 23:21
 */
@Api(value = "Echart图形管理相关的接口", tags = "echart")
@RestController
@RequestMapping("/echart")
public class EchartController {

    @ApiOperation(value = "获取图表基础结构", notes = " 获取图表基础结构")
    //@ApiImplicitParam(name = "type", value = "图表类型", paramType="path", required = true, dataType = "String")
    @RequestMapping(value = "/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //@GetMapping()
    public JsonResult get(@PathVariable String type) {
        if(StringUtils.isBlank(type)){
            return JsonResult.error();
        }
        String option = null;
        if("simpleEchartBar".equals(type)){
            List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
            List<Object> list2 = Lists.newArrayList(1, 4, 2, 5, 3, 2, 0);
            List<List<Object>> series = Lists.newArrayList(list1, list2);


            option = BarChartUtil.simpleEchartBar("未来一周气温变化",
                    Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                    Lists.newArrayList("最高气温", "最低气温"),
                    series);
        }else if("transverseEchartBar".equals(type)){
            List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
            List<Object> list2 = Lists.newArrayList(1, 4, 2, 5, 3, 2, 1);
            List<List<Object>> series = Lists.newArrayList(list1, list2);

            option = BarChartUtil.transverseEchartBar("未来一周气温变化",
                    Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                    Lists.newArrayList("最高气温", "最低气温"),
                    series);
        }else if("simpleChartFunnel".equals(type)){
            Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
            option = FunnelChartUtil.simpleChartFunnel("浏览器市场份额", map);
        }else if("simpleGaugeChart".equals(type)){
            option = GaugeChartUtil.simpleGaugeChart("5月业务指标","完成率",80);
        }else if("basicLineChart".equals(type)){
            List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
            List<Object> list2 = Lists.newArrayList(1, -2, 2, 5, 3, 2, 0);
            List<List<Object>> series = Lists.newArrayList(list1, list2);

            option = LineChartUtil.basicLineChart("未来一周气温变化",
                    Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                    Lists.newArrayList("最高气温", "最低气温"),
                    series);
        }else if("basicAreaChart".equals(type)){
            List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
            List<Object> list2 = Lists.newArrayList(1, 12, 2, 5, 3, 2, 0);
            List<List<Object>> series = Lists.newArrayList(list1, list2);

            option = LineChartUtil.basicAreaChart("未来一周气温变化",
                    Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                    Lists.newArrayList("最高气温", "最低气温"),
                    series);
        }else if("smoothedLineChart".equals(type)){
            List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
            List<Object> list2 = Lists.newArrayList(1, 12, 2, 5, 3, 2, 0);
            List<List<Object>> series = Lists.newArrayList(list1, list2);

            option = LineChartUtil.smoothedLineChart("未来一周气温变化",
                    Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                    Lists.newArrayList("最高气温", "最低气温"),
                    series);
        }else if("stackedAreaChart".equals(type)){
            List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
            List<Object> list2 = Lists.newArrayList(1, 22, 2, 5, 3, 2, 0);
            List<List<Object>> series = Lists.newArrayList(list1, list2);

            option = LineChartUtil.stackedAreaChart("未来一周气温变化",
                    Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                    Lists.newArrayList("最高气温", "最低气温"),
                    series);
        }else if("simpleChartPie".equals(type)){
            Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",54,"Firefox",13,"IE8",11);
            option = PieChartUtil.simpleChartPie("浏览器市场份额", map);
        }else if("radiusChartPiepie".equals(type)){
            Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
            option = PieChartUtil.radiusChartPiepie("浏览器市场份额", map);
        }else if("doughnutChartPie".equals(type)){
            Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
            option = PieChartUtil.doughnutChartPie("浏览器市场份额", map);
        }else if("roseDiagramChartPie".equals(type)){
            Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
            option = PieChartUtil.roseDiagramChartPie("浏览器市场份额", map);
        }else if("rectangularEchartPie".equals(type)){
            Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
            option = PieChartUtil.rectangularEchartPie("浏览器市场份额", map);
        }
        return JsonResult.ok(option);
    }
}
