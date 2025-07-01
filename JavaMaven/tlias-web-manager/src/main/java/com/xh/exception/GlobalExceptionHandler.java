package com.xh.exception;

import com.xh.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice   //用于不花控制器Controller抛出的异常
public class GlobalExceptionHandler {
    @ExceptionHandler //指定处理何种异常
    public Result doException(Exception e ) {
        log.error(e.getMessage());
        return Result.error("出错了，请联系管理员！");

    }
}
