package com.joycart.backend.util;

import com.joycart.backend.constant.LogConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * 日志工具类
 */
public final class LogUtil {
    
    private static final Logger log = LoggerFactory.getLogger(LogUtil.class);
    
    private LogUtil() {
        throw new IllegalStateException("工具类不应被实例化");
    }
    
    /**
     * 初始化请求日志上下文
     *
     * @param requestUri 请求URI
     * @return 请求ID
     */
    public static String initRequestContext(String requestUri) {
        String requestId = generateRequestId();
        MDC.put(LogConstants.MDC_REQUEST_ID, requestId);
        MDC.put(LogConstants.MDC_REQUEST_URI, requestUri);
        MDC.put(LogConstants.MDC_START_TIME, String.valueOf(System.currentTimeMillis()));
        return requestId;
    }
    
    /**
     * 设置用户ID到日志上下文
     *
     * @param userId 用户ID
     */
    public static void setUserId(String userId) {
        MDC.put(LogConstants.MDC_USER_ID, userId);
    }
    
    /**
     * 清理请求日志上下文
     */
    public static void clearContext() {
        MDC.clear();
    }
    
    /**
     * 生成请求ID
     *
     * @return 请求ID
     */
    public static String generateRequestId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    /**
     * 记录业务操作日志
     *
     * @param message 日志信息
     * @param args    参数
     */
    public static void business(String message, Object... args) {
        log.info(LogConstants.PREFIX_BUSINESS + " " + message, args);
    }
    
    /**
     * 记录API访问日志
     *
     * @param message 日志信息
     * @param args    参数
     */
    public static void api(String message, Object... args) {
        log.info(LogConstants.PREFIX_API + " " + message, args);
    }
    
    /**
     * 记录数据库操作日志
     *
     * @param message 日志信息
     * @param args    参数
     */
    public static void db(String message, Object... args) {
        log.info(LogConstants.PREFIX_DB + " " + message, args);
    }
    
    /**
     * 记录外部系统交互日志
     *
     * @param message 日志信息
     * @param args    参数
     */
    public static void external(String message, Object... args) {
        log.info(LogConstants.PREFIX_EXTERNAL + " " + message, args);
    }
    
    /**
     * 记录错误日志
     *
     * @param message 日志信息
     * @param throwable 异常
     */
    public static void error(String message, Throwable throwable) {
        log.error(message, throwable);
    }
    
    /**
     * 记录警告日志
     *
     * @param message 日志信息
     * @param args    参数
     */
    public static void warn(String message, Object... args) {
        log.warn(message, args);
    }
    
    /**
     * 记录调试日志
     *
     * @param message 日志信息
     * @param args    参数
     */
    public static void debug(String message, Object... args) {
        log.debug(message, args);
    }
    
    /**
     * 记录追踪日志
     *
     * @param message 日志信息
     * @param args    参数
     */
    public static void trace(String message, Object... args) {
        log.trace(message, args);
    }
} 