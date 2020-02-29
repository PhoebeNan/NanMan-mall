package com.zyn.mall.test.spring.security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaoyanan
 * @create 2020-02-29-16:29
 */
@Controller
@RequestMapping("/product")
public class ProductTestController {

    @RequestMapping("/info")
    @ResponseBody
    public String productInfo(){

        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("zyn");
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
        }else {
            currentUser = principl.toString();
        }
        return " some product info,currentUser is: "+currentUser;
    }
}
