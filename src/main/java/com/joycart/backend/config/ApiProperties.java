package com.joycart.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * API配置属性
 */
@Data
@Component
@ConfigurationProperties(prefix = "app.api")
public class ApiProperties {
    
    /**
     * API基础路径前缀
     */
    private String prefix;
    
    /**
     * CORS配置
     */
    private CorsConfig cors;
    
    /**
     * CORS配置内部类
     */
    @Data
    public static class CorsConfig {
        /**
         * 允许的源
         */
        private String allowedOrigins;
        
        /**
         * 允许的HTTP方法
         */
        private String allowedMethods;
        
        /**
         * 允许的请求头
         */
        private String allowedHeaders;
        
        /**
         * 是否允许凭证
         */
        private boolean allowCredentials;
        
        /**
         * 最大缓存时间（秒）
         */
        private long maxAge;
    }
} 