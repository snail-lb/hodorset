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
import com.snail2lb.web.commons.api.RoleAuthorities;
import com.snail2lb.web.system.service.RoleAuthoritiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
@RestController
@RequestMapping("/v1/roleAuthorities")
@Api(description = "角色权限关联表管理接口")
public class RoleAuthoritiesController {

    @Autowired
    private RoleAuthoritiesService roleAuthoritiesService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "增加角色权限关联表", notes = " 增加角色权限关联表")
    public boolean add(@RequestBody RoleAuthorities roleAuthorities){
        return roleAuthoritiesService.insert(roleAuthorities);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改角色权限关联表", notes = "修改角色权限关联表")
    public boolean update(@RequestBody RoleAuthorities roleAuthorities){
        return roleAuthoritiesService.update(roleAuthorities);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色权限关联表", notes = "删除角色权限关联表")
    public boolean delete(@RequestBody RoleAuthorities roleAuthorities){
        return roleAuthoritiesService.delete(roleAuthorities);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色权限关联表", notes = "删除角色权限关联表")
    public boolean deleteById(@PathVariable Integer id){
        return roleAuthoritiesService.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询角色权限关联表", notes = "根据ID查询角色权限关联表")
    public RoleAuthorities query(@PathVariable Integer id){
        return roleAuthoritiesService.selectById(id);
    }

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询角色权限关联表", notes = "根据条件查询角色权限关联表")
    public PageResult<RoleAuthorities> queryByPage(@RequestBody RoleAuthorities roleAuthorities,
                                                 @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                 @RequestParam(name = "pageSize", defaultValue = "20",  required = false) Integer pageSize){
        Page<RoleAuthorities> userPage = roleAuthoritiesService.selectByConditions(roleAuthorities, pageNum, pageSize);
        PageResult<RoleAuthorities> page = new PageResult<>(userPage);
        return page;
    }

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有角色权限关联表", notes = "查询所有角色权限关联表")
    public List<RoleAuthorities> queryAll(@RequestBody RoleAuthorities roleAuthorities){
        return roleAuthoritiesService.selectByConditions(roleAuthorities, -1, -1);
    }

}