package com.hcr.api.controller;

import com.hcr.api.dto.RoleDTO;
import com.hcr.api.service.RoleService;
import com.hcr.api.util.Paged;
import com.hcr.api.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "角色接口")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "分页获取角色列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int"),
        @ApiImplicitParam(name = "size", value = "页大小", required = true, dataType = "int")
    })
    @GetMapping("/getRoles")
    public Result<Paged<RoleDTO>> getRoles(int page, int size) {
        return roleService.getRoles(page, size);
    }
}
