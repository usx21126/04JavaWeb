package com.itheima.config;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration  //配置类
public class CommonConfig {
    @Bean   //程序启动时自动执行方法，方法返回值对象交给IOC容器管理
    public SAXReader sexReader() {
        log.info("创建sexReader.............");
        SAXReader saxReader = new SAXReader();
        return saxReader;
    }
}
