package com.joycart.backend.constant;

/**
 * API相关常量
 */
public final class ApiConstants {
    
    /**
     * 私有构造函数防止实例化
     */
    private ApiConstants() {
        throw new IllegalStateException("常量类不应被实例化");
    }
    
    /**
     * API前缀
     */
    public static final String API_PREFIX = "/api";
    
    /**
     * 用户API路径
     */
    public static final String USERS_PATH = API_PREFIX + "/users";
    
    /**
     * 认证API路径
     */
    public static final String AUTH_PATH = API_PREFIX + "/auth";
    
    /**
     * 允许的跨域源
     */
    public static final String CORS_ORIGIN = "http://localhost:8082";
} 