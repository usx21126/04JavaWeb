package com.xh.service.impl;


import com.xh.entity.Dept;
import com.xh.mapper.DeptMapper;
import com.xh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    /**
     * 根据ID删除部门数据
     * @param id
     */
    @Override
    public void deleteDept(int id) {
        deptMapper.deleteDept(id);
    }

    /**
     * 添加部门数据
     * @param dept
     */
    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept getDeptById(Integer id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
}
