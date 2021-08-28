package com.tingshuo.common.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusConfig
 * MybatisPlus 核心扫描包
 * @Auth yangZ
 * @Date 2021-08-15 22:30
 */
@Configuration
@MapperScan(value={"com.tingshuo.system.mapper"})
public class MybatisPlusConfig {
}
