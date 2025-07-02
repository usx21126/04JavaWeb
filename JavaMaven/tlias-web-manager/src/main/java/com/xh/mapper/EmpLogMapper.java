package com.xh.mapper;

import com.xh.entity.EmpLog;
import com.xh.entity.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLogMapper {

    public void insert(EmpLog empLog);

}
