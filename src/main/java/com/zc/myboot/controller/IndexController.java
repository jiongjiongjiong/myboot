package com.zc.myboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.zc.myboot.base.DemoEntity;
import com.zc.myboot.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @author: zc
 * @date: 2017/11/21
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private MessageSource messageSource;

    /**
     * 初始化登录页面
     * @return
     */
    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        logger.info("this is a log!");
        return "index";
    }


//    @ResponseBody
    @RequestMapping(value = "/login", produces = "application/json; charset=utf-8")
    public JSONObject login(HttpServletRequest request,String name) throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","用户："+name+"，登录成功。");
        //将返回值写入到请求对象中
        request.setAttribute(LoggerUtils.LOGGER_RETURN,jsonObject);
        return jsonObject;
    }

    @RequestMapping(value = "/validator")
    public String validator(@Valid DemoEntity entity, BindingResult result){
        if (result.hasErrors()){
            StringBuffer msg = new StringBuffer();
            List<FieldError> fieldErrors = result.getFieldErrors();
            //获取本地locale,zh_CN
            Locale currentLocale = LocaleContextHolder.getLocale();
            for (FieldError fieldError : fieldErrors){
                String errorMessage = messageSource.getMessage(fieldError,currentLocale);
                msg.append(fieldError.getField() + ":" + errorMessage + ",");
            }
            return msg.toString();
        }
        return "验证通过," + " 名称: " + entity.getName() + " 年龄 " + entity.getAge() + " 邮箱地址： " + entity.getEmail();
    }

}
