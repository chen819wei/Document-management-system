package servlet;

import dao.NoticeDao;
import entity.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/NoticeChangeServlet"},name = "NoticeChangeServlet")
public class NoticeChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Notice notice = new Notice(request.getParameter("title"), request.getParameter("department")
                , request.getParameter("notice"));
        int i=new NoticeDao().update(notice, Integer.parseInt(request.getParameter("id")));
        if (i == 0) {
            out.print("<script language='javascript'>alert('修改成功');window.close();</script>");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('修改失败');window.close();</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
