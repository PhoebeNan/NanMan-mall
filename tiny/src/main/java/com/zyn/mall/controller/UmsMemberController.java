package com.zyn.mall.controller;

import com.zyn.mall.common.CommonResult;
import com.zyn.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaoyanan
 * @create 2020-02-28-15:47
 */
@RestController
@CrossOrigin
@Api(tags = "UmsMemberController",description = "会员注册登录管理")
@RequestMapping("umsMember")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    //2.判断验证码是否正确
    @PostMapping("verifyAuthCode")
    @ApiOperation("判断验证码是否正确")
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam(required = false) String authCode){

        return umsMemberService.verifyAuthCode(telephone,authCode);
    }

    //1.获取验证码
    @ApiOperation("获取验证码")
    @GetMapping("getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone){

        String authCode  =umsMemberService.getAuthCode(telephone);

        if (StringUtils.isNotBlank(authCode)){
            return CommonResult.success(authCode);
        }
        return CommonResult.failure("获取验证码失败", authCode);
    }

}
