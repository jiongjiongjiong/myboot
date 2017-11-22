package com.zc.myboot.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Zhangc
 * @date: 2017/11/22
 */

public final class LoggerUtils {

    public static final  String LOGGER_RETURN  = "_logger_return";

    /**
     * 获取客户端ip
     * @param request
     * @return
     */
    public static String getCliectIp(HttpServletRequest request){
        String ip  = request.getHeader("x-forwarded-for");

        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }

        return ip;
    }

    /**
     * 获取客户端请求类型(判断是否为ajax请求)
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request){
        return request.getHeader("X-Requested-With");
    }

}
