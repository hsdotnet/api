package com.hcr.api.service.impl;

import com.hcr.api.dto.RoleDTO;
import com.hcr.api.service.RoleService;
import com.hcr.api.util.Paged;
import com.hcr.api.util.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Result<Paged<RoleDTO>> getRoles(int page, int size) {
        List<RoleDTO> roles = new ArrayList<RoleDTO>();

        int records = 2 * size + 3;

        int takeCount = page == 3 ? 3 : size;

        for (int i = 1; i <= size; i++) {
            RoleDTO role = new RoleDTO();
            role.setRoleId((page - 1) * size + i);
            role.setRoleName("角色名称：" + role.getRoleId());
            role.setRemark("角色备注：" + role.getRoleId());
            roles.add(role);
        }

        Paged<RoleDTO> paged = new Paged<RoleDTO>(page, size, records, roles);

        return Result.success(paged);
    }
}
