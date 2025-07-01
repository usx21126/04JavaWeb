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

    /**
     * 新增员工
     * @param emp
     */
    void addEmp(Emp emp);

    /**
     * 获取记录条数
     * @param param
     * @return
     */
    Integer getCount(EmpQueryParam param);
}
