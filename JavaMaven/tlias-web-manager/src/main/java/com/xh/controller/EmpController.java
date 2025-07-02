package com.xh.controller;

import com.xh.entity.*;
import com.xh.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 新增员工
     * @param emp
     * @return
     */
    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        log.info("emp={}",emp);
        log.info("exprList={}", emp.getExprList());
        empService.addEmp(emp);
        return Result.success();
    }

    /**
     * 删除员工
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteEmps(@RequestParam List<Integer> ids) {
        log.info("ids={}",ids);
        empService.deleteEmps(ids);
        return Result.success();
    }

    /**
     * 查询员工及工作经历
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        log.info("id={}",id);
        Emp emp= empService.getEmpById(id);
        return Result.success(emp);
    }

    /**
     * 修改员工
     * @param emp
     * @return
     */
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        log.info("emp={}",emp);
        empService.updateEmp(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getAllEmps() {
        List<Emp> empList = empService.getAllEmps();
        return Result.success(empList);
    }
}
