package com.xh;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求处理类
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("Hello World");
        return "Hello World";
    }
    @RequestMapping("/hello2")
    public String sayHello2() {
        System.out.println("Hello World2");
        return "Hello World2";
    }
}
