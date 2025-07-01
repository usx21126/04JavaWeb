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
import java.util.List;

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
     * @param param
     * @return
     */
    @Override
    public PageBean getEmps(EmpQueryParam param) {
        param.setOffset((param.getPage() - 1) * param.getPageSize());
        List<Emp> rows = empMapper.getEmps(param);
        Integer total = empMapper.getCount(param);
        PageBean pageBean = new PageBean(total,rows);
        return pageBean;


    }

    /**
     * 新增员工
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
            if(exprList != null && !exprList.isEmpty()) {
                exprList.forEach(empExpr->empExpr.setEmpId(id));
                empExprMapper.addEmpExprBatch(exprList);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            EmpLog empLog = new EmpLog();
            empLog.setOperateTime(LocalDateTime.now());
            empLog.setInfo("插入员工信息："+emp);
            empLogService.insertLog(empLog);
        }
    }
}
