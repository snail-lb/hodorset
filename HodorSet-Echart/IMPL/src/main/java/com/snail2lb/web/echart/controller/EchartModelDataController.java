package com.snail2lb.web.echart.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.snail2lb.web.common.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-16 11:49
 */
@Api(value = "Echart图形数据接口", tags = "modeldata")
@RestController
@RequestMapping("/modeldata")
public class EchartModelDataController {

    @ApiOperation(value = "标准的Echart获取数据接口结构", notes = "标准的Echart获取数据接口结构")
    @RequestMapping(value = "/data/array", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult getArrayData() {
        String data = String.format("{\n  \"dataset\": {\n    \"source\": [\n      [\n        \"product\",\n        \"2005\",\n        \"2006\",\n        \"2007\"\n      ],\n      [\n        \"张三\",\n        50,\n        50,\n        50\n      ],\n      [\n        \"李四\",\n        70.1,\n        70.1,\n        70.1\n      ],\n      [\n        \"王五\",\n        80.4,\n        80.4,\n        80.4\n      ][\n        \"赵六\",\n        90.5,\n        90.5,\n        90.5\n      ]\n    ]\n  }\n}");
        JSONObject obj = JSON.parseObject(data);
        return JsonResult.ok().put("dataset",obj);
    }

    @ApiOperation(value = "标准的Echart获取数据接口结构", notes = "标准的Echart获取数据接口结构")
    @RequestMapping(value = "/data/map", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult getMapData() {
        String data = String.format("{\n" +
                "    dataset: {\n" +
                "        dimensions: ['product', '2015', '2016', '2017'],\n" +
                "        source: [\n" +
                "            {product: 'Matcha Latte', '2015': 43.3, '2016': 85.8, '2017': 93.7},\n" +
                "            {product: 'Milk Tea', '2015': 83.1, '2016': 73.4, '2017': 55.1},\n" +
                "            {product: 'Cheese Cocoa', '2015': 86.4, '2016': 65.2, '2017': 82.5},\n" +
                "            {product: 'Walnut Brownie', '2015': 72.4, '2016': 53.9, '2017': 39.1}\n" +
                "        ]\n" +
                "    }\n" +
                "}");
        JSONObject obj = JSON.parseObject(data);
        return JsonResult.ok().put("dataset",obj);
    }
}
