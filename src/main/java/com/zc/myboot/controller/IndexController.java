package com.zc.myboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.zc.myboot.utils.LoggerUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zc
 * @date: 2017/11/21
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @RequestMapping(value = "/login_view", method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
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
}
