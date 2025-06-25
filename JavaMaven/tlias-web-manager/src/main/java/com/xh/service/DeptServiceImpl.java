package com.xh.service;

import com.xh.dao.DeptDao;
import com.xh.dao.DeptDaoImpl;
import com.xh.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
//@Component  //程序启动时，自动创建该类对象，并由IOC管理
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    public List<Dept> getAllDepts() throws FileNotFoundException {
        List<String> strings = deptDao.getAllDepts();
        List<Dept> depts = strings.stream().map((str)->{
            String[] parts = str.split(",");
            Integer id = Integer.valueOf(parts[0]);
            String name = parts[1];
            LocalDateTime date = LocalDateTime.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new Dept(id, name, date);
        }).toList();
        return depts;
    }
}
