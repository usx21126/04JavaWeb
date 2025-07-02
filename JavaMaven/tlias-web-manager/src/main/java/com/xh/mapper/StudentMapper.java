package com.xh.mapper;

import com.xh.entity.PageBean;
import com.xh.entity.Student;
import com.xh.entity.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 分页查询学员
     * @param param
     * @return
     */
    List<Student> getStudents(StudentQueryParam param);

    /**
     * 查询学员记录总数
     * @param param
     * @return
     */
    Integer getCount(StudentQueryParam param);

    /**
     * 根据clazzId删除学员
     * @param id
     */
    void deleteStudentsByClazzId(Integer id);

    /**
     * 根据id列表批量删除学员
     * @param ids
     */
    void deleteStudents(List<Integer> ids);

    /**
     * 添加学员数据
     * @param student
     */
    void addStudent(Student student);

    /**
     * 根据id查询学员数据
     * @param id
     * @return
     */
    Student getStudentById(Integer id);

    /**
     * 修改学员数据
     * @param student
     */
    void updateStudent(Student student);

    void updateStudentViolation(Integer id, Integer score);
}
