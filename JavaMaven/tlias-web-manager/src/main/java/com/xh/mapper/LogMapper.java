package com.xh.mapper;

import com.xh.entity.OperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {

    /**
     * 分页查询日志
     * @param offset
     * @param pageSize
     * @return
     */
    List<OperateLog> getLogs(Integer offset, Integer pageSize);

    /**
     * 获取日志记录总数
     * @param i
     * @param pageSize
     * @return
     */
    Integer getCount(int i, Integer pageSize);

    void addLog(OperateLog operateLog);
}
