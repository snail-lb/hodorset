package com.snail2lb.web.echart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snail2lb.web.common.JsonResult;
import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.echart.api.EchartModel;
import com.snail2lb.web.echart.service.EchartModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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

    @ApiOperation(value = "获取指定的图形结构", notes = "获取指定的图形结构")
    @RequestMapping(value = "/{group}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResult<EchartModel> getEchartModelByGroup(@PathVariable String group) {
        List<EchartModel> echartModels = echartModelService.slectByGroup(group);
        return new PageResult<EchartModel>(echartModels);
    }

    @ApiOperation(value = "获取所有的图形结构", notes = "获取所有的图形结构")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResult<EchartModel> getAllEchartModel(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new PageResult<EchartModel>(echartModelService.selectAll());
    }

    @ApiOperation(value = "添加一个图形结构", notes = "添加一个图形结构")
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult addEchartModel(@RequestBody EchartModel EchartModel) {
        boolean result = echartModelService.add(EchartModel);
        if(result){
            return JsonResult.ok("添加成功");
        }else{
            return JsonResult.error("添加失败");
        }
    }

    @ApiOperation(value = "修改一个图形结构", notes = "修改一个图形结构")
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult updateEchartModel(@RequestBody EchartModel EchartModel) {
        boolean result = echartModelService.update(EchartModel);
        if(result){
            return JsonResult.ok("修改成功");
        }else{
            return JsonResult.error("修改失败");
        }
    }

    @ApiOperation(value = "删除一个图形结构", notes = "删除一个图形结构")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult delEchartModel(@PathVariable Integer id) {
        boolean result = echartModelService.deleteById(id);
        if(result){
            return JsonResult.ok("删除成功");
        }else{
            return JsonResult.error("删除失败");
        }
    }


}
