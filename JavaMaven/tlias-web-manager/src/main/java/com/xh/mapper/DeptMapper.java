package com.xh.mapper;

import com.xh.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DeptMapper {
    /**
     * 查询部门列表
     * @return
     */
    public List<Dept> getAllDepts();

    /**
     * 根据ID删除部门数据
     * @param id
     * @return
     */
    public void deleteDept(int id);

    /**
     * 添加部门数据
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Dept getDeptById(Integer id);

    /**
     * 更新dept
     * @param dept
     */
    void updateDept(Dept dept);
}
