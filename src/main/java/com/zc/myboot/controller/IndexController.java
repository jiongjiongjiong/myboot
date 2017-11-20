package com.zc.myboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: zc
 * @date: 2017/11/21
 */
@Controller
@RequestMapping("/user")
public class IndexController {


    @RequestMapping(value = "/login_view", method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
