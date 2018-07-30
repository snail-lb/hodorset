package com.snail2lb.web.system.controller;

import com.snail2lb.web.common.JsonResult;
import com.snail2lb.web.common.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "登录注册相关的接口", tags = "main-controller")
@RestController
public class MainController extends BaseController {

    @ApiOperation(value = "获取个人信息")
    @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String")
    @GetMapping("/userInfo")
    public JsonResult userInfo() {
        return JsonResult.ok().put("user", getLoginUser());
    }
}
