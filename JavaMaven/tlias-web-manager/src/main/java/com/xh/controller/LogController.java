package com.xh.controller;

import com.xh.entity.OperateLog;
import com.xh.entity.PageBean;
import com.xh.entity.Result;
import com.xh.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;
    /**
     * 查询日志
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public Result getLogs(Integer page, Integer pageSize){
        PageBean pb = logService.getLogs(page,pageSize);
        return Result.success(pb);
    }

    public void addLog(OperateLog operateLog){
        logService.addLog(operateLog);
    }
}
