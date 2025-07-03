package com.xh.filter;

import com.xh.exception.BusinessException;
import com.xh.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
/**
 * @WebFilter("/*")
 */
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        log.info("uri: {}", uri);
        if (uri.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = request.getHeader("token");
        if (token == null) {
            response.setStatus(401);
            log.error("token is null");
//            throw new BusinessException("未登录，请先登录！");
            return;
        }
        try {
            Claims claims = JwtUtils.parseJWT(token);
        } catch (Exception e) {
            response.setStatus(401);
            log.error("令牌解析失败：{}",e.getMessage());
//            throw new BusinessException("未登录，请先登录！");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
