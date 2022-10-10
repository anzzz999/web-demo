package com.mengan.webdemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/** MyBatis配置类 */
@Configuration
@MapperScan("com.mengan.webdemo.mapper")
public class MyBatisConfig {}
