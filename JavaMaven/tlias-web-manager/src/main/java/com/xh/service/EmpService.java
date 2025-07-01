package com.xh.service;

import com.xh.entity.Emp;
import com.xh.entity.EmpQueryParam;
import com.xh.entity.PageBean;


public interface EmpService {
    PageBean getEmps(EmpQueryParam param);

    void addEmp(Emp emp);
}
