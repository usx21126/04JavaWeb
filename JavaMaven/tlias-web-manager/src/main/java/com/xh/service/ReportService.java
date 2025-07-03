package com.xh.service;

import com.xh.entity.DataBean;
import com.xh.entity.EmpJobData;
import com.xh.entity.StudentCountData;

import java.util.List;

public interface ReportService {

    List<DataBean> getEmpGenderData();

    EmpJobData getEmpJobData();

    List<DataBean> getStudentDegreeData();

    StudentCountData getStudentCountData();
}
