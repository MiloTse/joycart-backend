package com.joycart.backend.interceptor;

import com.joycart.backend.constant.LogConstants;
import com.joycart.backend.util.LogUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 请求日志拦截器
 * 用于记录请求日志和设置MDC上下文
 */
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 初始化请求上下文
        String requestId = LogUtil.initRequestContext(request.getRequestURI());
        
        // 记录请求开始日志
        LogUtil.api("接收请求 - 方法: {}, URI: {}, 远程地址: {}, 请求ID: {}",
                request.getMethod(),
                request.getRequestURI(),
                request.getRemoteAddr(),
                requestId);
        
        // 设置响应头，便于追踪问题
        response.setHeader("X-Request-ID", requestId);
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // 在控制器执行后，视图渲染前调用
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 计算耗时
        String startTimeStr = MDC.get(LogConstants.MDC_START_TIME);
        if (startTimeStr != null) {
            long startTime = Long.parseLong(startTimeStr);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            // 记录请求完成日志
            LogUtil.api("完成请求 - 方法: {}, URI: {}, 状态: {}, 耗时: {}ms",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    duration);
        }
        
        // 清理MDC上下文
        LogUtil.clearContext();
    }
} 