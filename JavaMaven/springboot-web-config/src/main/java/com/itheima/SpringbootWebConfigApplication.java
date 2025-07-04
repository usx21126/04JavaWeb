package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.HeaderParser;
import com.example.MyImportSelector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;


//@ComponentScan("com.itheima")   //启动类默认扫描路径
//@ComponentScan({"com.itheima","com.example"})
@Slf4j
@SpringBootApplication
@EnableHeaderConfig
//@Import({MyImportSelector.class})
public class SpringbootWebConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfigApplication.class, args);
    }
//    @Bean   //程序启动时自动执行方法，方法返回值对象交给IOC容器管理
//    public SAXReader sexReader() {
//        log.info("创建sexReader....");
//        SAXReader saxReader = new SAXReader();
//        return saxReader;
//    }
}
