package com.xh.dao;

import com.xh.entity.Dept;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
//@Component
@Repository
public class DeptDaoImpl implements DeptDao {
    public List<String> getAllDepts() throws FileNotFoundException {
        InputStream input = new FileInputStream("tlias-web-manager\\src\\main\\resources\\dept.txt");
        List<String> strings = IOUtils.readLines(input,"UTF-8");
        return strings;
    }
}
