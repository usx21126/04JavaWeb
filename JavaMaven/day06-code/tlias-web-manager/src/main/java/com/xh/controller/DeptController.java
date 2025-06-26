package com.xh.controller;


import com.xh.entity.Dept;
import com.xh.entity.Result;
import com.xh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * 请求处理类
 */
@RestController
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
     *
     * @return
     */
    @GetMapping("/depts")
    public Result getAllDepts(){
        List<Dept> depts = deptService.getAllDepts();
        return Result.success(depts);
    }
}
