package com.snail2lb.web.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.snail2lb.web.test.service.EchartModelService;
import com.snail2lb.web.test.vo.EchartModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-20 19:50:24
 */
@RestController
@RequestMapping("/v2/echartModel")
@Api(description = "echartModel管理接口")
public class EchartModelController {

    @Autowired
    private EchartModelService echartModelService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "增加echartModel", notes = " 增加echartModel")
    public boolean add(@RequestBody EchartModel echartModel){
        return echartModelService.insert(echartModel);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改echartModel", notes = "修改echartModel")
    public boolean update(@RequestBody EchartModel echartModel){
        return echartModelService.update(echartModel);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除echartModel", notes = "删除echartModel")
    public boolean delete(@RequestBody EchartModel echartModel){
        return echartModelService.delete(echartModel);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除echartModel", notes = "删除echartModel")
    public boolean deleteById(@PathVariable Integer id){
        return echartModelService.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询echartModel", notes = "根据ID查询echartModel")
    public EchartModel query(@PathVariable Integer id){
        return echartModelService.selectById(id);
    }

    @RequestMapping(value = "/{pageNum}/{pageSize}",method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询echartModel", notes = "根据条件查询echartModel")
    public PageInfo<EchartModel> queryByPage(@RequestBody EchartModel echartModel,@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        return echartModelService.selectByConditions(echartModel, pageNum, pageSize).toPageInfo();
    }

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有echartModel", notes = "查询所有echartModel")
    public Page<EchartModel> queryAll(@RequestBody EchartModel echartModel){
        return echartModelService.selectByConditions(echartModel, -1, -1);
    }

}