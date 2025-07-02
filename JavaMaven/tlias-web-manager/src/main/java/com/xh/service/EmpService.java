package com.xh.service;

import com.xh.entity.Emp;
import com.xh.entity.EmpQueryParam;
import com.xh.entity.PageBean;

import java.util.List;


public interface EmpService {
    PageBean getEmps(EmpQueryParam param);

    void addEmp(Emp emp);

    void deleteEmps(List<Integer> ids);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    List<Emp> getAllEmps();
}
