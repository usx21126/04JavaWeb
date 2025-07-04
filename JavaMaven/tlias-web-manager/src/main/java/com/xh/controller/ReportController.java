package com.xh.controller;

import com.xh.entity.*;
import com.xh.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 获取男女员工人数
     * @return
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        List<DataBean> list = reportService.getEmpGenderData();
        return Result.success(list);
    }
    /**
     * 员工职位人数统计
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        EmpJobData empJobData = reportService.getEmpJobData();
        return Result.success(empJobData);
    }

    /**
     * 学员学历统计
     * @return
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        List<DataBean> dataBeanList = reportService.getStudentDegreeData();
        return Result.success(dataBeanList);
    }

    /**
     * 班级人数统计
     * @return
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        StudentCountData studentCountData = reportService.getStudentCountData();
        return Result.success(studentCountData);
    }

}
