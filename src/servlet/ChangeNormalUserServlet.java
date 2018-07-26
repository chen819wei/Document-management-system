package servlet;

import dao.NormalUserDao;
import dao.NoticeDao;
import entity.NormalUser;
import entity.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/ChangeNormalUserServlet"},name = "ChangeNormalUserServlet")
public class ChangeNormalUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        NormalUser normalUser = new NormalUser(request.getParameter("account"), request.getParameter("password")
                , request.getParameter("department"));
        int i=new NormalUserDao().update(normalUser, Integer.parseInt(request.getParameter("id")));
        if (i == 0) {
            out.print("<script language='javascript'>alert('修改用户信息成功');window.opener.location.reload();window.close();</script>");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('修改用户信息失败');window.opener.location.reload();window.close();</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
