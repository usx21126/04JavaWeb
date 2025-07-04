package com.xh.service.impl;

import com.xh.entity.OperateLog;
import com.xh.entity.PageBean;
import com.xh.mapper.LogMapper;
import com.xh.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public PageBean getLogs(Integer page, Integer pageSize) {
        PageBean pageBean = new PageBean();
        pageBean.setRows(logMapper.getLogs((page-1)*pageSize,pageSize));
        pageBean.setTotal(logMapper.getCount((page-1)*pageSize,pageSize));
        return pageBean;
    }

    @Override
    public void addLog(OperateLog operateLog) {
        logMapper.addLog(operateLog);
    }
}
