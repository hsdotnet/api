package com.hcr.api.service;

import com.hcr.api.dto.DeptDTO;
import com.hcr.api.util.Result;

import java.util.List;

public interface DeptService {
    Result<DeptDTO> getDeptById(int deptId);

    Result<List<DeptDTO>> getDepts();
}
