package com.xh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置状态吗
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        //设置响应头
        resp.setHeader("xh","java-servlet");

        //设置响应数据
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("<h1>Hello World</h1>");
        resp.getWriter().println("<h1>Hello 李华</h1>");

        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
