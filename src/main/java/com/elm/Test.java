package com.elm;

import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>测试Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>你好</h1>");
        out.println("<p>这是一个简单的Servlet示例</p>");
        out.println("</body>");
        out.println("</html>");

        System.out.println("收到来自 " + req.getRemoteAddr() + " 的GET请求");
    }
}