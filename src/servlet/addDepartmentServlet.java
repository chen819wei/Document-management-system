package servlet;

import dao.AdminUserDao;
import dao.DepartmentDao;
import entity.AdminUser;
import entity.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/addDepartmentServlet"},name = "addDepartmentServlet")
public class addDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Department department = new Department(request.getParameter("department_name"));
        int i=new DepartmentDao().insert(department);
        if (i == 0) {
            out.print("<script language='javascript'>alert('添加部门成功');window.close();</script>");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('添加部门失败');window.close();</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
