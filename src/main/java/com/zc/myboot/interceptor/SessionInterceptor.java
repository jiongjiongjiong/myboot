package com.zc.myboot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截
 * @author: zc
 * @date: 2017/11/21
 */
public class SessionInterceptor  implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.info("request uri: {}",request.getRequestURI());
        //登录不做拦截
//        if ( request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view") ){
//            return true;
//        }
//
//        //验证session是否存在
//        Object obj = request.getSession().getAttribute("session_user");
//        if (obj == null){
//            response.sendRedirect("/user/login_view");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
