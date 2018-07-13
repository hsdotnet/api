package com.hcr.api.service;

import com.hcr.api.dto.UserDTO;
import com.hcr.api.util.Result;

import java.util.List;

public interface UserService {
    Result<UserDTO> getUserInfo(String userName, String password);

    Result<UserDTO> getUserInfoById(int userId);

    Result<UserDTO> getUserInfoByUserName(String userName);

    Result<List<UserDTO>> getUsers(int deptId, String userName, String email);
}
