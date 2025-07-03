package com.xh.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("Filter init");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("Filter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Filter doFilter 放行前");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("Filter doFilter 放行后");
    }
}
