package com.hcr.api.service.impl;

import com.hcr.api.dto.DeptDTO;
import com.hcr.api.dto.TreeDTO;
import com.hcr.api.service.DeptService;
import com.hcr.api.util.Result;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    private final List<DeptDTO> depts = new ArrayList<DeptDTO>();

    public DeptServiceImpl() {
        DeptDTO dept1 = new DeptDTO();
        dept1.setDeptCode("TH1001");
        dept1.setDeptId(1);
        dept1.setDeptName("信息技术部");
        dept1.setParentId(0);
        dept1.setRemark("信息技术部");
        depts.add(dept1);

        DeptDTO dept2 = new DeptDTO();
        dept2.setDeptCode("TH1002");
        dept2.setDeptId(2);
        dept2.setDeptName("测试部");
        dept2.setParentId(1);
        dept2.setRemark("测试部");
        depts.add(dept2);

        DeptDTO dept3 = new DeptDTO();
        dept3.setDeptCode("TH1003");
        dept3.setDeptId(3);
        dept3.setDeptName("测试一部");
        dept3.setParentId(2);
        dept3.setRemark("测试一部");
        depts.add(dept3);

        DeptDTO dept4 = new DeptDTO();
        dept4.setDeptCode("TH1004");
        dept4.setDeptId(4);
        dept4.setDeptName("研发部");
        dept4.setParentId(1);
        dept4.setRemark("研发部");
        depts.add(dept4);
    }

    @Override
    public Result<DeptDTO> getDeptById(int deptId) {
        for (DeptDTO dept : depts) {
            if (dept.getDeptId() == deptId) {
                return Result.success(dept);
            }
        }

        return Result.error("未找到对应的用户信息");
    }

    @Override
    public Result<List<DeptDTO>> getDepts() {
        return Result.success(depts);
    }

    @Override
    public Result<List<TreeDTO>> getDeptTree() {
        List<TreeDTO> trees = new ArrayList<TreeDTO>();

        TreeDTO root = new TreeDTO();
        root.setId(0);
        root.setTitle("部门目录");
        root.setExpand(true);
        root.setChildren(getDeptTree(0));
        trees.add(root);

        return Result.success(trees);
    }

    private List<TreeDTO> getDeptTree(int parentId) {
        List<TreeDTO> trees = new ArrayList<TreeDTO>();

        depts.forEach(dept -> {
            if (dept.getParentId() == parentId) {
                TreeDTO tree = new TreeDTO();
                tree.setId(dept.getDeptId());
                tree.setTitle(dept.getDeptName());
                tree.setExpand(true);
                tree.setChildren(getDeptTree(dept.getDeptId()));
                trees.add(tree);
            }
        });

        return trees;
    }

    ;
}
