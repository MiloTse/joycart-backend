package com.joycart.backend.util;

import java.util.UUID;

/**
 * 字符串工具类
 */
public class StringUtil {

    private StringUtil() {
        // 私有构造函数防止实例化
    }
    
    /**
     * 判断字符串是否为空或仅包含空白字符
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    /**
     * 判断字符串是否不为空且不仅包含空白字符
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
    
    /**
     * 截取字符串，如果超出最大长度，则添加省略号
     */
    public static String truncate(String str, int maxLength) {
        if (str == null) {
            return null;
        }
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength) + "...";
    }
    
    /**
     * 生成UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * 生成不带连字符的UUID
     */
    public static String generateUUIDWithoutHyphens() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    /**
     * 首字母大写
     */
    public static String capitalize(String str) {
        if (isBlank(str)) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
    
    /**
     * 首字母小写
     */
    public static String uncapitalize(String str) {
        if (isBlank(str)) {
            return str;
        }
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }
} 