package com.xh.dao;

import java.io.FileNotFoundException;
import java.util.List;

public interface DeptDao {
    /**
     *
     * @return
     */
    public List<String> getAllDepts() throws FileNotFoundException;
}
