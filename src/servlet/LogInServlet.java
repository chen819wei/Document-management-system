package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/LogInServlet"},name = "LogInServlet")
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        if (request.getParameter("user_name").equals("admin") && request.getParameter("user_password").equals("admin")) {
            System.out.println("登录成功");
            out.write("{\"onSuccess\":\"登录成功\"}");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('账号或者密码错误');window.location.href='index.jsp';</script>");
            out.close();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}