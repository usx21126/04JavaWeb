package com.xh.mapper;

import com.xh.entity.Emp;
import com.xh.entity.EmpQueryParam;
import com.xh.entity.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询所有员工
     * @return
     */
    List<Emp> getEmps(EmpQueryParam param);

    void addEmp(Emp emp);

    /**
     * 查询总记录数
     * @return
     */
    Integer getCount(EmpQueryParam param);
}
