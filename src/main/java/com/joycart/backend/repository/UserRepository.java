package com.joycart.backend.repository;

import com.joycart.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 所有基本的 CRUD 操作都由 JpaRepository 提供
    // 可以根据需要添加自定义方法
}
