package com.xh.service.impl;

import com.xh.entity.*;
import com.xh.mapper.ReportMapper;
import com.xh.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    /**
     * 获取员工男女人数
     *
     * @return
     */
    @Override
    public List<DataBean> getEmpGenderData() {
        List<Integer> count = reportMapper.getGenderCount();
        List<DataBean> list = new ArrayList<DataBean>();
        list.add(new DataBean("男性员工", count.get(0)));
        list.add(new DataBean("女性员工", count.get(1)));
        return list;

    }

    /**
     * 员工职位人数统计
     *
     * @return
     */
    @Override
    public EmpJobData getEmpJobData() {

        List<EmpJobCount> empJobCountList = reportMapper.getJobCount();
        List<String> jobList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        empJobCountList.forEach(empJobCount -> {
            switch (empJobCount.getJob()) {
                case 1:
                    jobList.add("班主任");
                    dataList.add(empJobCount.getCnt());
                    break;
                case 2:
                    jobList.add("讲师");
                    dataList.add(empJobCount.getCnt());
                    break;
                case 3:
                    jobList.add("学工主管");
                    dataList.add(empJobCount.getCnt());
                    break;
                case 4:
                    jobList.add("教研主管");
                    dataList.add(empJobCount.getCnt());
                    break;
                case 5:
                    jobList.add("咨询师");
                    dataList.add(empJobCount.getCnt());
                    break;
                default:
                    jobList.add("其他");
                    dataList.add(empJobCount.getCnt());
                    break;
            }
        });
        return new EmpJobData(jobList,dataList);
    }

    /**
     * 学员学历统计
     * @return
     */
    @Override
    public List<DataBean> getStudentDegreeData() {
        List<StudentDegreeCount> studentDegreeCountList = reportMapper.getDegreeCount();
        List<DataBean> list = new ArrayList<>();
        studentDegreeCountList.forEach(studentDegreeCount -> {
            switch (studentDegreeCount.getDegree()) {
                case 1:
                    list.add(new DataBean("初中",studentDegreeCount.getCount()));
                    break;
                case 2:
                    list.add(new DataBean("高中",studentDegreeCount.getCount()));
                    break;
                case 3:
                    list.add(new DataBean("大专",studentDegreeCount.getCount()));
                    break;
                case 4:
                    list.add(new DataBean("本科",studentDegreeCount.getCount()));
                    break;
                case 5:
                    list.add(new DataBean("硕士",studentDegreeCount.getCount()));
                    break;
                case 6:
                    list.add(new DataBean("博士",studentDegreeCount.getCount()));
                    break;
            }
        });
        return list;
    }

    @Override
    public StudentCountData getStudentCountData() {
        List<String> clazzList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        List<DataBean> dataBeanList = reportMapper.getStudentCountData();
        dataBeanList.forEach(dataBean -> {
            clazzList.add(dataBean.getName());
            dataList.add(dataBean.getValue());
        });
        StudentCountData studentCountData = new StudentCountData(clazzList,dataList);
        return studentCountData;
    }
}
