package com.zc.myboot.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zc.myboot.entity.LoggerEntity;
import com.zc.myboot.jpa.LoggerJPA;
import com.zc.myboot.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 日志拦截记录
 * @author: Zhangc
 * @date: 2017/11/22
 */

public class LoggerInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //创建日志实体
        LoggerEntity loggerEntity = new LoggerEntity();
        //获取请求sessionId
        String sessionId = request.getRequestedSessionId();
        //获取请求路径
        String uri = request.getRequestURI();
        //获取请求参数
        String paramData = JSON.toJSONString(
                request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);

        loggerEntity.setClientIp(LoggerUtils.getCliectIp(request));
        loggerEntity.setSessionId(sessionId);
        loggerEntity.setUri(uri);
        loggerEntity.setMethod(request.getMethod());
        loggerEntity.setType(LoggerUtils.getRequestType(request));
        loggerEntity.setParamData(paramData);
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        //设置请求实体到request内，方面afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY, loggerEntity);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //获取请求错误码
        int status = response.getStatus();
        //获取当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = (long) request.getAttribute(LOGGER_SEND_TIME);
        //获取本次请求日志实体
        LoggerEntity loggerEntity = (LoggerEntity) request.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        loggerEntity.setTimeConsuming(Integer.valueOf((currentTime - time) +""));
        //设置返回时间
        loggerEntity.setReturnTime(currentTime + "");
        //设置返回错误码
        loggerEntity.setHttpStatusCode(status+"");
        //设置返回数据
        loggerEntity.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));

        //执行将日志写入数据库
        LoggerJPA loggerDAO = getDao(LoggerJPA.class,request);
        logger.info("insert data: {}",loggerEntity);
        loggerDAO.save(loggerEntity);
    }

    /**
     * 根据传入的类型获取spring管理的对应bean
     * @param clazz
     * @param request
     * @param <T>
     * @return
     */
    private <T> T getDao(Class<T> clazz, HttpServletRequest request){
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
