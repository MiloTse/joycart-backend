package com.joycart.backend.mapper;

import com.joycart.backend.dto.UserCreateRequest;
import com.joycart.backend.dto.UserDTO;
import com.joycart.backend.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户实体与DTO的转换器
 */
@Component
public class UserMapper {

    /**
     * 实体转DTO
     */
    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
    
    /**
     * 实体列表转DTO列表
     */
    public List<UserDTO> toDTOList(List<User> users) {
        if (users == null) {
            return null;
        }
        
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * 创建请求转实体
     */
    public User toEntity(UserCreateRequest request) {
        if (request == null) {
            return null;
        }
        
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // 实际应用中应该对密码进行加密
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        return user;
    }
} 