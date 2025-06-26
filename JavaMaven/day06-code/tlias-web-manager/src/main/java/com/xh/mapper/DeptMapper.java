package com.xh.mapper;

import com.xh.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.sql.ResultSet;
import java.util.List;
@Mapper
public interface DeptMapper {
    /**
     * 查询部门列表
     * @return
     */
    public List<Dept> getAllDepts();
}
