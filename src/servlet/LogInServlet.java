package servlet;

import dao.NormalUserDao;
import entity.NormalUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/LogInServlet"},name = "LogInServlet")
public class LogInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String radio =request.getParameter("user");
        String user_name=request.getParameter("user_name");

        //判断是否为普通用户
        if (radio.equals("普通用户")) {
            System.out.println("普通用户");
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
                        request.setAttribute("user_name",normalUser);
                        System.out.println(request.getAttribute("user_name"));
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
            System.out.println("公文管理用户");
            out.print("<script language='javascript'>alert('账号或者密码错误');window.location.href='index.jsp';</script>");
            out.close();
        } else {
            System.out.println("管理员");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}