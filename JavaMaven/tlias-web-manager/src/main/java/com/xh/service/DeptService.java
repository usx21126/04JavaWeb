package com.xh.service;

import com.xh.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> getAllDepts() ;
    void deleteDept(int id) ;

    void addDept(Dept dept) ;

    Dept getDeptById(Integer id);

    void updateDept(Dept dept);
}
