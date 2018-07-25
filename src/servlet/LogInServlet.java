package servlet;

import dao.AdminUserDao;
import dao.AdministratorDao;
import dao.NormalUserDao;
import dao.NoticeDao;
import entity.AdminUser;
import entity.Administrator;
import entity.NormalUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/*
* 用户登录servlet
* */
@WebServlet(urlPatterns = {"/LogInServlet"},name = "LogInServlet")
public class LogInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //获取用户选择的是哪个类型的用户
        String radio =request.getParameter("user");
        //获取用户名
        String user_name=request.getParameter("user_name");
        //判断是否为普通用户
        if (radio.equals("普通用户")) {
            System.out.println("普通用户");
            //查询该用户信息
            NormalUser normalUser=new NormalUserDao().select(user_name);
            //判断账号是否存在
            if (normalUser != null) {
                //判断账号密码是都正确
                if (user_name.equals(normalUser.getUser_name())
                        && request.getParameter("user_password").equals(normalUser.getUser_password())) {
                    //response.sendRedirect("/normalUser.jsp");
                    /*HttpSession session = request.getSession();
                    session.setAttribute("name",request.getParameter("user_name"));*/
                   // request.getSession().setAttribute("user_name ",user_name);
                    try {
                        //将用户信息传递到用户界面
                        request.setAttribute("user_name",normalUser);
                        System.out.println(request.getAttribute("user_name"));
                        //将部门信息传过去
                        request.setAttribute("department",new NoticeDao().selectAll(normalUser.getDepartment()));
                        request.getRequestDispatcher("/normalUser.jsp").forward(request,response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                } else {
                    out.print("<script language='javascript'>alert('账号或者密码错误');window.location.href='index.jsp';</script>");
                    out.close();
                }
            } else {
                out.print("<script language='javascript'>alert('账号不存在');window.location.href='index.jsp';</script>");
                out.close();
            }
        } else if (radio.equals("公文管理用户")) {
            //查询该用户信息
            AdminUser adminUser = new AdminUserDao().select(user_name);
            //判断账号是否存在
            if (adminUser != null) {
                if (user_name.equals(adminUser.getUser_name())
                        && request.getParameter("user_password").equals(adminUser.getUser_password())) {
                    try {
                        //将用户信息传递到用户界面
                        request.setAttribute("adminUser", adminUser);
                        request.setAttribute("department",new NoticeDao().selectAll(adminUser.getDepartment()));
                        request.getRequestDispatcher("/adminUser.jsp").forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                } else {
                    out.print("<script language='javascript'>alert('账号或者密码错误');window.location.href='index.jsp';</script>");
                    out.close();
                }
            } else {
                out.print("<script language='javascript'>alert('账号不存在');window.location.href='index.jsp';</script>");
                out.close();
            }

        } else {
            //查询该用户信息
            Administrator administrator = new AdministratorDao().select(user_name);
            //判断账号是否存在
            if (administrator != null) {
                if (user_name.equals(administrator.getUser_name())
                        && request.getParameter("user_password").equals(administrator.getUser_password())) {
                    try {
                        //将用户信息传递到用户界面
                        request.setAttribute("administrator", administrator);
                        request.getRequestDispatcher("/administrator.jsp").forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                } else {
                    out.print("<script language='javascript'>alert('账号或者密码错误');window.location.href='index.jsp';</script>");
                    out.close();
                }
            } else {
                out.print("<script language='javascript'>alert('账号不存在');window.location.href='index.jsp';</script>");
                out.close();
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}