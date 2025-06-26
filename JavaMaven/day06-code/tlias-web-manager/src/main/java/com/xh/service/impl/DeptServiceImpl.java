package com.xh.service.impl;


import com.xh.entity.Dept;
import com.xh.mapper.DeptMapper;
import com.xh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Component  //程序启动时，自动创建该类对象，并由IOC管理
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    public List<Dept> getAllDepts()   {
        List<Dept> strings = deptMapper.getAllDepts();

        return strings;
    }
}
