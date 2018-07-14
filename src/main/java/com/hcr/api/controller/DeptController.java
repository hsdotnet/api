package com.hcr.api.controller;

import com.hcr.api.dto.DeptDTO;
import com.hcr.api.dto.TreeDTO;
import com.hcr.api.service.DeptService;
import com.hcr.api.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "部门接口")
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ApiOperation(value = "根据部门Id获取部门信息")
    @ApiImplicitParam(name = "deptId", value = "部门Id", required = true, dataType = "int")
    @GetMapping("/getDeptById")
    public Result<DeptDTO> getDeptById(int deptId) {
        return deptService.getDeptById(deptId);
    }

    @ApiOperation(value = "获取部门列表")
    @GetMapping("/getDepts")
    public Result<List<DeptDTO>> getDepts() {
        return deptService.getDepts();
    }

    @ApiOperation(value = "获取部门树")
    @GetMapping("/getDeptTree")
    public Result<List<TreeDTO>> getDeptTree() {
        return deptService.getDeptTree();
    }
}
