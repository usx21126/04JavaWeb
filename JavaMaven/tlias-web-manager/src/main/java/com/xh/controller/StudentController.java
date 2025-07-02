package com.xh.controller;

import com.xh.entity.PageBean;
import com.xh.entity.Result;
import com.xh.entity.Student;
import com.xh.entity.StudentQueryParam;
import com.xh.mapper.StudentMapper;
import com.xh.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询学员
     * @param param
     * @return
     */
    @GetMapping
    public Result getStudents(StudentQueryParam param) {
        log.info("param:{}", param);
        PageBean pb = studentService.getStudents(param);
        return Result.success(pb);
    }

    /**
     * 根据id列表批量删除学员
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result deleteStudents(@PathVariable List<Integer> ids) {
        log.info("ids:{}", ids);
        studentService.deleteStudents(ids);
        return Result.success();
    }

    /**
     * 添加学员数据
     * @param student
     * @return
     */
    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        log.info("student:{}", student);
        studentService.addStudent(student);
        return Result.success();
    }

    /**
     * 根据id查询学员
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getStudentById(@PathVariable Integer id) {
        log.info("id:{}", id);
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }

    /**
     * 修改学员数据
     * @param student
     * @return
     */
    @PutMapping
    public Result updateStudent(@RequestBody Student student) {
        log.info("student:{}", student);
        studentService.updateStudent(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateStudentViolation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("id:{},score:{}", id, score);
        studentService.updateStudentViolation(id,score);
        return Result.success();
    }
}
