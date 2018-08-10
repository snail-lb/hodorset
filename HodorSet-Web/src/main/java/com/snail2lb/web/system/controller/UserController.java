package com.snail2lb.web.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snail2lb.web.common.BaseController;
import com.snail2lb.web.common.JsonResult;
import com.snail2lb.web.common.PageResult;
import com.snail2lb.web.common.utils.StringUtil;
import com.snail2lb.web.commons.api.Role;
import com.snail2lb.web.commons.api.User;
import com.snail2lb.web.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户相关的接口", tags = "user")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 这里参数过多，并且参数含有中文，建议用post请求，用restful风格解决不了需求时，建议不要强行使用restful
     * 加了一个/query是避免跟添加用户接口冲突
     */
    @ApiOperation(value = "查询所有用户", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "searchKey", value = "筛选条件字段", dataType = "String"),
            @ApiImplicitParam(name = "searchValue", value = "筛选条件关键字", dataType = "String"),
            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String")
    })
    @PostMapping("/query")
    public PageResult<User> list(Integer page, Integer limit, String searchKey, String searchValue) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        if (StringUtil.isBlank(searchValue)) {
            searchKey = null;
        }
        return userService.list(page, limit, true, searchKey, searchValue);
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User"),
            @ApiImplicitParam(name = "roleId", value = "用户角色id，多个用','分割", required = true, dataType = "String"),
            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String")
    })
    @PostMapping()
    public JsonResult add(User user, String roleId) {
        List<Role> roleIds = new ArrayList<>();
        String[] split = roleId.split(",");
        for (String t : split) {
            Role role = new Role();
            role.setRoleId(t);
            roleIds.add(role);
        }
        user.setRoles(roleIds);
        if (userService.add(user)) {
            return JsonResult.ok("添加成功");
        } else {
            return JsonResult.error("添加失败");
        }
    }

    @ApiOperation(value = "修改用户", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User"),
            @ApiImplicitParam(name = "roleId", value = "用户角色id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String")
    })
    @PutMapping()
    public JsonResult update(User user, String roleId) {
        List<Role> roleIds = new ArrayList<>();
        String[] split = roleId.split(",");
        for (String t : split) {
            Role role = new Role();
            role.setRoleId(t);
            roleIds.add(role);
        }
        user.setRoles(roleIds);
        if (userService.update(user)) {
            return JsonResult.ok("修改成功");
        } else {
            return JsonResult.error("修改失败");
        }
    }

    @ApiOperation(value = "修改用户状态", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "state", value = "状态：0正常，1冻结", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String")
    })
    @PutMapping("/state")
    public JsonResult updateState(String userId, Integer state) {
        if (userService.updateState(userId, state)) {
            return JsonResult.ok();
        } else {
            return JsonResult.error();
        }
    }

    @ApiOperation(value = "修改自己密码", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPsw", value = "原密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newPsw", value = "新密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String")
    })
    @PutMapping("/psw")
    public JsonResult updatePsw(String oldPsw, String newPsw) {
        String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode(oldPsw);
        if (finalSecret.equals(getLoginUser().getPassword())) {
            return JsonResult.error("原密码输入不正确");
        }
        if (userService.updatePsw(getLoginUserId(), newPsw)) {
            return JsonResult.ok("修改成功");
        } else {
            return JsonResult.error("修改失败");
        }
    }

    @ApiOperation(value = "重置密码", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "passWord", value = "用户密码", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String")
    })
    @PutMapping("/psw/{id}/{psw}")
    public JsonResult resetPsw(@PathVariable("id") String userId,@PathVariable("passWord") String passWord) {
        if (userService.updatePsw(userId, passWord)) {
            return JsonResult.ok("重置成功");
        } else {
            return JsonResult.error("重置失败");
        }
    }
}
