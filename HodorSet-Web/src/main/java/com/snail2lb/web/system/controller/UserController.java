package com.snail2lb.web.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.commons.api.User;
import com.snail2lb.web.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
@RestController
@RequestMapping("/v1/user")
@Api(description = "用户表管理接口")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "增加用户表", notes = " 增加用户表")
    public boolean add(@RequestBody User user){
        return userService.insert(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户表", notes = "修改用户表")
    public boolean update(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户表", notes = "删除用户表")
    public boolean delete(@RequestBody User user){
        return userService.delete(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户表", notes = "删除用户表")
    public boolean deleteById(@PathVariable Integer id){
        return userService.deleteById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询用户表", notes = "根据ID查询用户表")
    public User query(@PathVariable Integer id){
        return userService.selectById(id);
    }

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询用户表", notes = "根据条件查询用户表")
    public PageResult<User> queryByPage(@RequestBody(required = false) User user,
                                      @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "20",  required = false) Integer pageSize){
        Page<User> userPage = userService.selectByConditions(user, pageNum, pageSize);
        PageResult<User> page = new PageResult<>(userPage.getTotal(), userPage.getPageNum(), userPage.getPageSize(), userPage.getResult());
        return page;
    }

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有用户表", notes = "查询所有用户表")
    public Page<User> queryAll(@RequestBody User user){
        return userService.selectByConditions(user, -1, -1);
    }

}