package com.xh.mapper;

import com.xh.entity.DataBean;
import com.xh.entity.EmpJobCount;
import com.xh.entity.OperateLog;
import com.xh.entity.StudentDegreeCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

    /**
     * 分别获取男女员工数量
     * @return
     */
    List<Integer> getGenderCount();



    /**
     * 获取职位数量
     * @return
     */
    List<EmpJobCount> getJobCount();

    /**
     * 学员学历统计
     * @return
     */
    List<StudentDegreeCount> getDegreeCount();

    List<DataBean> getStudentCountData();
}
