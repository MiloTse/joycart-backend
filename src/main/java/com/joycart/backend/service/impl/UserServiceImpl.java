package com.joycart.backend.service.impl;

import com.joycart.backend.dto.UserCreateRequest;
import com.joycart.backend.dto.UserDTO;
import com.joycart.backend.entity.User;
import com.joycart.backend.exception.ResourceNotFoundException;
import com.joycart.backend.mapper.UserMapper;
import com.joycart.backend.repository.UserRepository;
import com.joycart.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return userMapper.toDTO(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDTO currentUser() {
        // 在实际应用中，这里应该从安全上下文中获取当前用户
        // 这里简化为直接获取ID为1的用户
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("Current user not found"));
        return userMapper.toDTO(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public UserDTO createUser(UserCreateRequest request) {
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public UserDTO updateUser(Long id, UserCreateRequest request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        
        // 更新用户信息
        existingUser.setUsername(request.getUsername());
        existingUser.setPassword(request.getPassword()); // 实际应用中应该对密码进行加密
        existingUser.setEmail(request.getEmail());
        existingUser.setPhone(request.getPhone());
        
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }
}
