package com.xh.controller;


import com.xh.entity.Dept;
import com.xh.entity.Result;
import com.xh.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * 请求处理类
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired  //从IOC容器中，自动寻找Bean对象，为该变量赋值
    private DeptService deptService;
    /**
     * 部门列表查询
     * @return
     * @throws FileNotFoundException
     */
//    @RequestMapping("/depts")
//    public List<Dept> getAllDepts() throws FileNotFoundException {
//        //读取txt至列表
//        InputStream input = new FileInputStream("tlias-web-manager\\src\\main\\resources\\dept.txt");
//        List<String> strings = IOUtils.readLines(input,"UTF-8");
//
//        //封装为集合
//        List<Dept> depts = strings.stream().map((str)->{
//            String[] parts = str.split(",");
//            Integer id = Integer.valueOf(parts[0]);
//            String name = parts[1];
//            LocalDateTime date = LocalDateTime.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new Dept(id, name, date);
//        }).toList();
//        return depts;
//    }
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)

    /**
     *查询所有部门
     * @return
     */
    @GetMapping
    public Result getAllDepts(){
        List<Dept> depts = deptService.getAllDepts();
        return Result.success(depts);
    }
    /**
     * 根据ID查询部门
     */
    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id){
        Dept dept = deptService.getDeptById(id);
        return Result.success(dept);
    }
    /**
     * 根据ID删除部门数据
     * @param
     * @return
     */
    @DeleteMapping
    /*public Result deleteDept(HttpServletRequest request){
        String id = request.getParameter("id");
        if(deptService.deleteDept(Integer.valueOf(id)))return Result.success();
        return Result.error("删除失败");
    }*/
    // @RequestParam加上后，前端必须要传递该参数，否则就报400 ，Bad Request,除非加上required=false
    public Result deleteDept(Integer id){
        log.info("id = {}",id);
        deptService.deleteDept(id);
        return Result.success();

    }

    /**
     * 添加部门数据
     * @param
     */
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        System.out.println(dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }


}
