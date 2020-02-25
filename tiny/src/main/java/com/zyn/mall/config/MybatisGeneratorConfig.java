package com.zyn.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类,用于配置需要动态生成的mapper接口的路径
 * @author zhaoyanan
 * @create 2020-02-25-16:08
 */
@Configuration
@MapperScan("com.zyn.mall.mbg.mapper")
public class MybatisGeneratorConfig {
}
