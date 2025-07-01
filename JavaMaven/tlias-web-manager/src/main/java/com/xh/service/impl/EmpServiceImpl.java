package com.xh.service.impl;

import com.xh.entity.*;
import com.xh.mapper.EmpExprMapper;
import com.xh.mapper.EmpLogMapper;
import com.xh.mapper.EmpMapper;
import com.xh.service.EmpLogService;
import com.xh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;

    /**
     * 分页查询员工列表
     *
     * @param param
     * @return
     */
    @Override
    public PageBean getEmps(EmpQueryParam param) {
        param.setOffset((param.getPage() - 1) * param.getPageSize());
        List<Emp> rows = empMapper.getEmps(param);
        Integer total = empMapper.getCount(param);
        PageBean pageBean = new PageBean(total, rows);
        return pageBean;


    }

    /**
     * 新增员工
     *
     * @param emp
     */
    @Transactional(rollbackFor = {Exception.class}) //开启事务
    @Override
    public void addEmp(Emp emp) {
        try {
            emp.setPassword("123456");
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.addEmp(emp);
            Integer id = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if (exprList != null && !exprList.isEmpty()) {
                exprList.forEach(empExpr -> empExpr.setEmpId(id));
                empExprMapper.addEmpExprBatch(exprList);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            EmpLog empLog = new EmpLog();
            empLog.setOperateTime(LocalDateTime.now());
            empLog.setInfo("插入员工信息：" + emp);
            empLogService.insertLog(empLog);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteEmps(List<Integer> ids) {
        if (ids != null && !ids.isEmpty()) {
            empMapper.deleteEmps(ids);
            empExprMapper.deleteEmpExprs(ids);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Emp getEmpById(Integer id) {
//        Emp emp = empMapper.getEmpById(id);
//        List<EmpExpr> exprList = empExprMapper.getEmpExprById(id);
//        emp.setExprList(exprList);
        Emp emp = empMapper.getEmpById2(id);
        return emp;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
        empExprMapper.deleteEmpExprById(emp.getId());
        List<EmpExpr> exprList = emp.getExprList();
        System.out.println("***");

        exprList.forEach(empExpr -> {
            empExpr.setEmpId(emp.getId());
        });
        //过滤空白员工经理
        exprList = exprList.stream().filter(empExpr -> !((empExpr.getCompany() == null || empExpr.getCompany().isEmpty()) &&
                (empExpr.getJob() == null || empExpr.getJob().isEmpty()) &&
                (empExpr.getBegin() == null) &&
                (empExpr.getEnd() == null))).toList();
        if (exprList != null && !exprList.isEmpty()) {
            empExprMapper.addEmpExprBatch(exprList);
        }
    }
}
