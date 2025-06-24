package com.xh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("method"+req.getMethod());
        System.out.println("uri" + req.getRequestURI());
        System.out.println("url" + req.getRequestURL());
        //获取协议
        System.out.println("scheme" + req.getScheme());
        //获取请求头
        System.out.println("host"+req.getHeader("Host"));

        System.out.println("name"+req.getParameter("name"));
        System.out.println("queryString"+req.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
