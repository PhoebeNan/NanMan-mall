package com.zyn.mall.service.impl;

import com.zyn.mall.common.CommonResult;
import com.zyn.mall.redis.RedisService;
import com.zyn.mall.service.UmsMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyanan
 * @create 2020-02-28-16:18
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;  //自定义redis key的前缀，key= 前缀+telephone

    @Value("${redis.key.expire.authCode}")
    private Long REDIS_KEY_EXPIRE_AUTH_CODE; //验证码超期时间(秒)默认为120秒

    //2.判断验证码是否正确
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {

        if (StringUtils.isBlank(authCode)){
            return CommonResult.failure("请输入验证码");
        }

        //验证码在redis中的key键
        String key = REDIS_KEY_PREFIX_AUTH_CODE + telephone;

        String value = redisService.get(key);

        if(StringUtils.isBlank(value)){
            return CommonResult.failure("请输入验证码或验证码已过期",authCode);
        }

        if (!authCode.equals(value)){
            return CommonResult.failure("验证码不正确",authCode);
        }

        return CommonResult.success("验证码校验成功", authCode);
    }

    //1.获取验证码
    @Override
    public String getAuthCode(String telephone) {

        StringBuilder builder = new StringBuilder();

        //1.存储到redis中的key
        String key = REDIS_KEY_PREFIX_AUTH_CODE + telephone;

        //2.存储到redis中的value    也可以用UUID  //UUID.randomUUID().toString().replace("-", "").toLowerCase()
        //生成一个随机的int值，该值介于[0,n)的区间
        for (int i = 0; i < 6; i++) {  //6位数的验证码

            builder.append(new Random().nextInt(10));
        }
        String value = builder.toString();

        //将验证码存储到redis中
        redisService.set(key, value);
        //设置其过期时间
        redisService.setExpireTimeByKey(key, REDIS_KEY_EXPIRE_AUTH_CODE, TimeUnit.SECONDS);

        return value;
    }
}
