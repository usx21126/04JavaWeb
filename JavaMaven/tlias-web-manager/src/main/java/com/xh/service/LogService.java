package com.xh.service;

import com.xh.entity.OperateLog;
import com.xh.entity.PageBean;

public interface LogService {

    PageBean getLogs(Integer page, Integer pageSize);

    void addLog(OperateLog operateLog);
}
