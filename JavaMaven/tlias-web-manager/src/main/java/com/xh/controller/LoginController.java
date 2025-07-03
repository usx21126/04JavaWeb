package com.xh.controller;

import com.xh.entity.Emp;
import com.xh.entity.EmpLoginInfo;
import com.xh.entity.Result;
import com.xh.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        EmpLoginInfo empLoginInfo = empService.login(emp);
        if (empLoginInfo == null){
            return Result.error("用户名或密码错误");
        }
        return Result.success(empLoginInfo);
    }
}
