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

    /**
     * 根据id列表删除数据
     * @param ids
     */
    void deleteEmps(List<Integer> ids);

    /**
     * 根据id获取员工数据（不含员工经历）
     * @param id
     * @return
     */
    Emp getEmpById(Integer id);

    /**
     * 根据id获取员工数据
     * @param id
     * @return
     */
    Emp getEmpById2(Integer id);

    /**
     * 更新员工表
     * @param emp
     */
    void updateEmp(Emp emp);

    List<Emp> getAllEmps();

    Emp getEmpByUsernameAndPassword(Emp emp);
}
