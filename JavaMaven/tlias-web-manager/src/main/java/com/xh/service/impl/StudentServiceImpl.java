package com.xh.service.impl;

import com.xh.entity.PageBean;
import com.xh.entity.Student;
import com.xh.entity.StudentQueryParam;
import com.xh.mapper.StudentMapper;
import com.xh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询学院
     * @param param
     * @return
     */
    @Override
    public PageBean getStudents(StudentQueryParam param) {
        param.setOffset((param.getPage() - 1) * param.getPageSize());
        PageBean pageBean = new PageBean();
        pageBean.setRows(studentMapper.getStudents(param));
        pageBean.setTotal(studentMapper.getCount(param));
        return pageBean;
    }

    /**
     * 根据id列表批量删除学员
     * @param ids
     */
    @Override
    public void deleteStudents(List<Integer> ids) {
        if (ids != null && !ids.isEmpty()) {
            studentMapper.deleteStudents(ids);
        }
    }

    /**
     * 添加学员数据
     * @param student
     */
    @Override
    public void addStudent(Student student) {
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.addStudent(student);
    }

    /**
     * 根据id查询学员数据
     * @param id
     * @return
     */
    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    /**
     * 修改学员数据
     * @param student
     */
    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }

    @Override
    public void updateStudentViolation(Integer id, Integer score) {
        studentMapper.updateStudentViolation(id,score);

    }
}
