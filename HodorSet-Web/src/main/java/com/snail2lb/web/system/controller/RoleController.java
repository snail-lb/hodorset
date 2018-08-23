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
import com.snail2lb.web.commons.api.Role;
import com.snail2lb.web.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
@RestController
@RequestMapping("/v1/role")
@Api(description = "角色表管理接口")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "增加角色表", notes = " 增加角色表")
    public boolean add(@RequestBody Role role){
        return roleService.insert(role);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改角色表", notes = "修改角色表")
    public boolean update(@RequestBody Role role){
        return roleService.update(role);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色表", notes = "删除角色表")
    public boolean delete(@RequestBody Role role){
        return roleService.delete(role);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色表", notes = "删除角色表")
    public boolean deleteById(@PathVariable Integer id){
        return roleService.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询角色表", notes = "根据ID查询角色表")
    public Role query(@PathVariable Integer id){
        return roleService.selectById(id);
    }

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询角色表", notes = "根据条件查询角色表")
    public PageResult<Role> queryByPage(@RequestBody Role role,
                                      @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "20",  required = false) Integer pageSize){
        Page<Role> userPage = roleService.selectByConditions(role, pageNum, pageSize);
        PageResult<Role> page = new PageResult<>(userPage);
        return page;
    }

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有角色表", notes = "查询所有角色表")
    public List<Role> queryAll(@RequestBody Role role){
        return roleService.selectByConditions(role, -1, -1);
    }
}