package com.snail2lb.web.system.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snail2lb.web.common.BaseController;
import com.snail2lb.web.common.JsonResult;
import com.snail2lb.web.system.model.Role;
import com.snail2lb.web.system.model.User;
import com.snail2lb.web.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "登录注册相关的接口", tags = "main-controller")
@RestController
public class MainController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取个人信息")
    @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String")
    @GetMapping("/userInfo")
    public JsonResult userInfo() {
        return JsonResult.ok().put("user", getLoginUser());
    }

    @ApiOperation(value = "注册用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @PostMapping("/register")
    public JsonResult register(User user) {
        Role role = new Role();
        //暂时设置默认角色为user
        role.setRoleId("user");
        user.setRoles(Arrays.asList(role));

        boolean result = userService.add(user);
        if (result) {
            return JsonResult.ok("注册用户成功");
        }else{
            return JsonResult.error("注册用户失败");
        }
    }

    @ApiOperation(value = "根据username检查用户是否存在")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
    @GetMapping("/verifyUsername")
    public JsonResult verifyUsername(String username) {
        User user = userService.getByUsername(username);
        if (null == user) {
            return JsonResult.ok("用户不存在");
        } else {
            return JsonResult.error("用户已存在");
        }
    }
}
