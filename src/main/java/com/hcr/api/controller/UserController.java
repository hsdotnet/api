package com.hcr.api.controller;

import com.hcr.api.dto.LoginDTO;
import com.hcr.api.dto.UserDTO;
import com.hcr.api.service.UserService;
import com.hcr.api.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @ApiImplicitParam(name = "loginDTO", value = "登录参数", required = true)
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO.getUserName(), loginDTO.getPassword());
    }

    @ApiOperation(value = "用户退出")
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success("OK");
    }

    @ApiOperation(value = "根据用户Id获取用户信息")
    @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "int")
    @GetMapping("/getUserInfoById")
    public Result<UserDTO> getUserInfoById(int userId) {
        return userService.getUserInfoById(userId);
    }

    @ApiOperation(value = "根据用户名获取用户信息")
    @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "string")
    @GetMapping("/getUserInfoByUserName")
    public Result<UserDTO> getUserInfoByUserName(String userName) {
        return userService.getUserInfoByUserName(userName);
    }

    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptId", value = "部门Id", required = false, dataType = "int"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = false, dataType = "string"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = false, dataType = "string")
    })
    @GetMapping("/getUsers")
    public Result<List<UserDTO>> getUsers(int deptId, String userName, String email) {
        return userService.getUsers(deptId, userName, email);
    }
}
