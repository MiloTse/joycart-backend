package com.joycart.backend.constant;

/**
 * 日志相关常量
 */
public final class LogConstants {
    
    private LogConstants() {
        throw new IllegalStateException("常量类不应被实例化");
    }
    
    /**
     * MDC键: 请求ID
     */
    public static final String MDC_REQUEST_ID = "requestId";
    
    /**
     * MDC键: 用户ID
     */
    public static final String MDC_USER_ID = "userId";
    
    /**
     * MDC键: 请求URI
     */
    public static final String MDC_REQUEST_URI = "requestUri";
    
    /**
     * MDC键: 请求开始时间
     */
    public static final String MDC_START_TIME = "startTime";
    
    /**
     * 日志前缀: 业务操作
     */
    public static final String PREFIX_BUSINESS = "[BUSINESS]";
    
    /**
     * 日志前缀: API访问
     */
    public static final String PREFIX_API = "[API]";
    
    /**
     * 日志前缀: 数据库操作
     */
    public static final String PREFIX_DB = "[DB]";
    
    /**
     * 日志前缀: 外部系统交互
     */
    public static final String PREFIX_EXTERNAL = "[EXTERNAL]";
} 