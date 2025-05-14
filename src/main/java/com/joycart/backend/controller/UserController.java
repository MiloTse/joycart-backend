package com.joycart.backend.controller;

import com.joycart.backend.constant.ApiConstants;
import com.joycart.backend.dto.UserCreateRequest;
import com.joycart.backend.dto.UserDTO;
import com.joycart.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping(ApiConstants.USERS_PATH)
@CrossOrigin(origins = ApiConstants.CORS_ORIGIN)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户DTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    /**
     * 获取所有用户
     * @return 用户DTO列表
     */
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> listAll() {
        return ResponseEntity.ok(userService.findAll());
    }



    /**
     * 创建用户
     * @param request 用户创建请求
     * @return 创建的用户DTO
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateRequest request) {
        UserDTO createdUser = userService.createUser(request);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     * 更新用户
     * @param id 用户ID
     * @param request 用户更新请求
     * @return 更新后的用户DTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Long id, 
            @Valid @RequestBody UserCreateRequest request) {
        UserDTO updatedUser = userService.updateUser(id, request);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 无内容响应
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
