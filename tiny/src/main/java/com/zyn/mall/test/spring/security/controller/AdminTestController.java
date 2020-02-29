package com.zyn.mall.test.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaoyanan
 * @create 2020-02-29-16:29
 */
@Controller
@RequestMapping("/admin")
public class AdminTestController {

    @RequestMapping("/home")
    @ResponseBody
    public String productInfo(){
        return " admin home page ";
    }
}