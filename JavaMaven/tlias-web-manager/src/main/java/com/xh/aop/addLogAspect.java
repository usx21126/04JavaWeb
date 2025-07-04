package com.xh.aop;

import com.xh.controller.LogController;
import com.xh.entity.OperateLog;
import com.xh.entity.Result;
import com.xh.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class addLogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LogController logController;
    @Around("execution(* com.xh.controller..*(..))&& !within(com.xh.controller.LogController) ")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Long beginTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        String token = request.getHeader("token");
        Integer id = null ;
        String userName = null;
        if(token != null) {

            try {
                Claims claims = JwtUtils.parseJWT(token);
                id = claims.get("id", Integer.class);
                userName = claims.get("username", String.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        OperateLog operateLog = new OperateLog(null,id,LocalDateTime.now(),joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()),String.valueOf(result).substring(0,Math.min(2000,String.valueOf(result).length())),endTime - beginTime,
                userName);
        operateLog.setOperateEmpId(id);
        logController.addLog(operateLog);
        return result;
    }
}
