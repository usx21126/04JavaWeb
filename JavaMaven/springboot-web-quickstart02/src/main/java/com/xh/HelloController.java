package com.xh;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello3")
    public String sayHello() {
        System.out.println("Hello World3");
        return "Hello World3";
    }
}
