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

@WebServlet(urlPatterns = {"/ReleaseNoticeServlet"},name = "ReleaseNoticeServlet")
public class ReleaseNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Notice notice;
        if(request.getParameter("people")!=null){
             notice = new Notice(request.getParameter("title")
                    , request.getParameter("notice"),request.getParameter("department"),request.getParameter("people"));
        }else {
             notice = new Notice(request.getParameter("title")
                    , request.getParameter("notice"), request.getParameter("department"));
        }
        int i = new NoticeDao().insert(notice);
        if (i == 0) {
            out.print("<script language='javascript'>alert('公文发布成功');\n" +
                    "window.opener.location.reload();window.close();</script>");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('公文发布失败');\n" +
                    "window.opener.location.reload();window.close();</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
