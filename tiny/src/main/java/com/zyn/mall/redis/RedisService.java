package com.zyn.mall.redis;

import java.util.concurrent.TimeUnit;

/**
 * 自定义操作redis的接口
 * 对象和数组都以json形式进行存储
 *
 * @author zhaoyanan
 * @create 2020-02-28-16:20
 */
public interface RedisService {

    //对象和数组都以json形式进行存储,所以参数用String表示

    //1.向redis里存入数据
    void set(String key, String value);

    //2.根据key获取缓存中的val
    String get(String key);

    //3.根据key设置过期时间
    void setExpireTimeByKey(String key,long timeout,TimeUnit timeUnit);

    //4.根据key获取过期时间并换算成指定单位
    Long getExpireTimeByKey(String key, TimeUnit timeUnit);

    //5.删除redis中的值
    void removeByKey(String key);

    //6.检查key是否存在，返回boolean值
    Boolean hasKey(String key);

    //7.根据key查看集合中是否存在指定数据
    Boolean isMember(String key, String value);
}
