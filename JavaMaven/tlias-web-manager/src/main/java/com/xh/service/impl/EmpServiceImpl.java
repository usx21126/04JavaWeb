package com.xh.service.impl;

import com.github.pagehelper.PageHelper;
import com.xh.entity.Emp;
import com.xh.entity.EmpQueryParam;
import com.xh.entity.PageBean;
import com.xh.mapper.EmpMapper;
import com.xh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

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

    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }
}
