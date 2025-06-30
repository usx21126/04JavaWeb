package com.xh.controller;

import com.xh.entity.Emp;
import com.xh.entity.EmpQueryParam;
import com.xh.entity.PageBean;
import com.xh.entity.Result;
import com.xh.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;

    /**
     * 根据条件查询员工列表
     * @param param
     * @return
     */
    @GetMapping
    public Result getEmps(EmpQueryParam param) {
        log.info("name={},gender={},begin={},end={},page={},pageSize={}", param.getName(), param.getGender(), param.getBegin(), param.getEnd(), param.getPage(), param.getPageSize());
        PageBean pb = empService.getEmps(param);
        return Result.success(pb);
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        log.info("emp={}", emp);
        empService.addEmp(emp);
        return Result.success();
    }
}
