package servlet;

import dao.DepartmentDao;
import dao.NormalUserDao;
import entity.Department;
import entity.NormalUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/ChangeDepartmentServlet"},name = "ChangeDepartmentServlet")
public class ChangeDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Department department = new Department(request.getParameter("account"));
        int i=new DepartmentDao().update(department, Integer.parseInt(request.getParameter("id")));
        if (i == 0) {
            out.print("<script language='javascript'>alert('修改部门信息成功');window.opener.location.reload();window.close();</script>");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('修改部门信息失败');window.opener.location.reload();window.close();</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
