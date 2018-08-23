package com.snail2lb.web.system.controller;

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
import com.snail2lb.web.commons.api.Authorities;
import com.snail2lb.web.system.service.AuthoritiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:47
 */
@RestController
@RequestMapping("/v1/authorities")
@Api(description = "权限表管理接口")
public class AuthoritiesController {

    @Autowired
    private AuthoritiesService authoritiesService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "增加权限表", notes = " 增加权限表")
    public boolean add(@RequestBody Authorities authorities){
        return authoritiesService.insert(authorities);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改权限表", notes = "修改权限表")
    public boolean update(@RequestBody Authorities authorities){
        return authoritiesService.update(authorities);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除权限表", notes = "删除权限表")
    public boolean delete(@RequestBody Authorities authorities){
        return authoritiesService.delete(authorities);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除权限表", notes = "删除权限表")
    public boolean deleteById(@PathVariable Integer id){
        return authoritiesService.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询权限表", notes = "根据ID查询权限表")
    public Authorities query(@PathVariable Integer id){
        return authoritiesService.selectById(id);
    }

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询权限表", notes = "根据条件查询权限表")
    public PageResult<Authorities> queryByPage(@RequestBody Authorities authorities,
                                               @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                               @RequestParam(name = "pageSize", defaultValue = "20",  required = false) Integer pageSize){
        Page<Authorities> userPage = authoritiesService.selectByConditions(authorities, pageNum, pageSize);
        PageResult<Authorities> page = new PageResult<>(userPage);
        return page;
    }

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有权限表", notes = "查询所有权限表")
    public List<Authorities> queryAll(@RequestBody Authorities authorities){
        return authoritiesService.selectByConditions(authorities, -1, -1);
    }

}