package com.hcr.api.service;

import com.hcr.api.dto.RoleDTO;
import com.hcr.api.util.Paged;
import com.hcr.api.util.Result;

public interface RoleService {
    Result<Paged<RoleDTO>> getRoles(int page, int size);
}
