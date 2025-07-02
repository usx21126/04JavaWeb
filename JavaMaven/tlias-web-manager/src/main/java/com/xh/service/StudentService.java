package com.xh.service;

import com.xh.entity.PageBean;
import com.xh.entity.Student;
import com.xh.entity.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageBean getStudents(StudentQueryParam param);

    void deleteStudents(List<Integer> ids);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void updateStudent(Student student);

    void updateStudentViolation(Integer id, Integer score);
}
