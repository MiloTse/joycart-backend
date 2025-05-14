package com.joycart.backend.service;
import com.joycart.backend.dto.UserCreateRequest;
import com.joycart.backend.dto.UserDTO;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {

    /**
     * 通过ID查找用户
     * @param id 用户ID
     * @return 用户DTO
     */
    UserDTO findById(Long id);

    /**
     * 获取所有用户
     * @return 用户DTO列表
     */
    List<UserDTO> findAll();
    
    /**
     * 创建新用户
     * @param request 用户创建请求
     * @return 创建后的用户DTO
     */
    UserDTO createUser(UserCreateRequest request);
    
    /**
     * 更新用户
     * @param id 用户ID
     * @param request 用户更新请求
     * @return 更新后的用户DTO
     */
    UserDTO updateUser(Long id, UserCreateRequest request);
    
    /**
     * 删除用户
     * @param id 用户ID
     */
    void deleteUser(Long id);
}
