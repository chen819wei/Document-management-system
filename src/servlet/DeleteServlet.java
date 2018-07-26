package servlet;

import dao.NoticeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/DeleteServlet"}, name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int i= Integer.parseInt(request.getParameter("delete_id"));
        int j=new NoticeDao().delete(i);
        if (j == 0) {
            out.print("<script language='javascript'>alert('É¾³ý³É¹¦');window.close();</script>");

            //response.sendRedirect("/normalUser.jsp");
            request.getRequestDispatcher("/LogInServlet").forward(request, response);
            out.close();
        } else {
            out.print("<script language='javascript'>alert('É¾³ýÊ§°Ü');window.close();</script>");
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
