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

    @ApiOperation(value = "获取指定的默认图形结构", notes = "获取指定的默认图形结构")
    @RequestMapping(value = "/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResult<CustomOption> getCustomOptionByType(@PathVariable String type) {
        List<CustomOption> customOptions = customOptionService.selectByType(type);
        return new PageResult<CustomOption>(customOptions);
    }

    @ApiOperation(value = "获取所有的默认图形结构", notes = "获取所有的默认图形结构")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResult<CustomOption> getAllCustomOption(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return customOptionService.selectAllPage(pageNum, pageSize);
    }

    @ApiOperation(value = "添加一个默认图形结构", notes = "添加一个默认图形结构")
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult addCustomOption(@RequestBody CustomOption customOption) {
        boolean result = customOptionService.add(customOption);
        if(result){
            return JsonResult.ok("添加成功");
        }else{
            return JsonResult.error("添加失败");
        }
    }

    @ApiOperation(value = "修改一个默认图形结构", notes = "修改一个默认图形结构")
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult updateCustomOption(@RequestBody CustomOption customOption) {
        boolean result = customOptionService.update(customOption);
        if(result){
            return JsonResult.ok("修改成功");
        }else{
            return JsonResult.error("修改失败");
        }
    }

    @ApiOperation(value = "删除一个默认图形结构", notes = "删除一个默认图形结构")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JsonResult delCustomOption(@PathVariable Integer id) {
        boolean result = customOptionService.deleteById(id);
        if(result){
            return JsonResult.ok("删除成功");
        }else{
            return JsonResult.error("删除失败");
        }
    }

}
