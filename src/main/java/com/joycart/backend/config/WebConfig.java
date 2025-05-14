package com.joycart.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ApiProperties apiProperties;

    @Autowired
    public WebConfig(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    /**
     * 跨域配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(apiProperties.getPrefix() + "/**")
                .allowedOrigins(apiProperties.getCors().getAllowedOrigins())
                .allowedMethods(apiProperties.getCors().getAllowedMethods().split(","))
                .allowedHeaders(apiProperties.getCors().getAllowedHeaders())
                .allowCredentials(apiProperties.getCors().isAllowCredentials())
                .maxAge(apiProperties.getCors().getMaxAge());
    }
} 