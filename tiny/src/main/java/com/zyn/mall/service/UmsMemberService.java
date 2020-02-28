package com.zyn.mall.service;

import com.zyn.mall.common.CommonResult;

/**
 * @author zhaoyanan
 * @create 2020-02-28-15:54
 */
public interface UmsMemberService {

    //2.判断验证码是否正确
    CommonResult verifyAuthCode(String telephone, String authCode);

    //1.获取验证码
    String getAuthCode(String telephone);
}
