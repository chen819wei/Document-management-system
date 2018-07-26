package servlet;

import dao.AdminUserDao;
import dao.NormalUserDao;
import entity.AdminUser;
import entity.NormalUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/AddAdminUserServlet"},name = "AddAdminUserServlet")
public class AddAdminUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        AdminUser adminUser = new AdminUser(request.getParameter("account"), request.getParameter("password")
                , request.getParameter("department"));
        int i=new AdminUserDao().insert(adminUser);
        if (i == 0) {
            out.print("<script language='javascript'>alert('添加公文用户成功');window.opener.location.reload();window.close();</script>");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('添加公文用户失败');window.opener.location.reload();window.close();</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
