package com.zyn.mall.redis.impl;

import com.zyn.mall.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyanan
 * @create 2020-02-28-16:45
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void set(String key, String value) {
        template.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {

        return template.opsForValue().get(key);
    }

    @Override
    public void setExpireTimeByKey(String key, long timeout, TimeUnit timeUnit) {

        template.expire(key, timeout, timeUnit);
    }

    @Override
    public Long getExpireTimeByKey(String key, TimeUnit timeUnit) {

        return template.getExpire(key, timeUnit);
    }

    @Override
    public void removeByKey(String key) {

        template.delete(key);
    }

    @Override
    public Boolean hasKey(String key) {

        return template.hasKey(key);
    }

    @Override
    public Boolean isMember(String key, String value) {

        return template.opsForSet().isMember(key, value);
    }
}
