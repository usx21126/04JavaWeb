package com.xh.controller;

import com.xh.entity.Clazz;
import com.xh.entity.ClazzQueryParam;
import com.xh.entity.PageBean;
import com.xh.entity.Result;
import com.xh.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    /**
     * 分页查询班级
     * @return
     */
    @GetMapping
    public Result getClazzs(ClazzQueryParam param) {
        log.info("param:{}", param);
        PageBean pb = clazzService.getClazzs(param);
        return Result.success(pb);
    }

    /**
     * 根据id删除班级
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteClazzs(@PathVariable Integer id) {
        log.info("id:{}", id);
        clazzService.deleteClazzs(id);
        return Result.success();
    }

    /**
     * 添加班级数据
     * @param clazz
     * @return
     */
    @PostMapping
    public Result addClazzs(@RequestBody Clazz clazz) {
        log.info("clazz:{}", clazz);
        clazzService.addClazzs(clazz);
        return Result.success();
    }

    /**
     * 根据id查询班级
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable Integer id) {
        log.info("id:{}", id);
        Clazz clazz = clazzService.getClazzById(id);
        return Result.success(clazz);
    }

    /**
     * 修改课程数据
     * @param clazz
     * @return
     */
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz) {
        log.info("clazz:{}", clazz);
        clazzService.updateClazz(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getAllClazzs() {
        List<Clazz> clazzList = clazzService.getAllClazzs();
        return Result.success(clazzList);
    }
}
