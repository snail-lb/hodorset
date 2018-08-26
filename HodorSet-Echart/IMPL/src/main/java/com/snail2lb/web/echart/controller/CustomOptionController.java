package com.snail2lb.web.echart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.echart.api.vo.CustomOption;
import com.snail2lb.web.echart.service.CustomOptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-21 18:33:22
 */
@RestController
@RequestMapping("/v1/customOption")
@Api(description = "customOption管理接口")
public class CustomOptionController {

    @Autowired
    private CustomOptionService customOptionService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "增加customOption", notes = " 增加customOption")
    public boolean add(@RequestBody CustomOption customOption){
        return customOptionService.insert(customOption);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改customOption", notes = "修改customOption")
    public boolean update(@RequestBody CustomOption customOption){
        return customOptionService.update(customOption);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除customOption", notes = "删除customOption")
    public boolean delete(@RequestBody CustomOption customOption){
        return customOptionService.delete(customOption);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除customOption", notes = "删除customOption")
    public boolean deleteById(@PathVariable Integer id){
        return customOptionService.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询customOption", notes = "根据ID查询customOption")
    public CustomOption query(@PathVariable Integer id){
        return customOptionService.selectById(id);
    }

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询customOption", notes = "根据条件查询customOption")
    public PageResult<CustomOption> queryByPage(@RequestBody CustomOption customOption,
                                              @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                              @RequestParam(name = "pageSize", defaultValue = "20",  required = false) Integer pageSize){
        Page<CustomOption> userPage = customOptionService.selectByConditions(customOption, pageNum, pageSize);
        PageResult<CustomOption> page = new PageResult<>(userPage);
        return page;
    }

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有customOption", notes = "查询所有customOption")
    public List<CustomOption> queryAll(@RequestBody CustomOption customOption){
        return customOptionService.selectByConditions(customOption, -1, -1);
    }

}