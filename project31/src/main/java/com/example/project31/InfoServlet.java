package com.example.project31;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InfoServlet", value = "/Info")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>info</title></head>");

        StringBuffer url = request.getRequestURL();//반환하는 타입이 StringBuffer
        String uri = request.getRequestURI();//반환하는 타입이 String;
        String contentPath = request.getContextPath();
        String remoteAddr = request.getRemoteAddr();
        out.println("<body>");
        out.println("<h1>");

        out.println("URL"+url+"<br>");
        out.println("URI"+uri+"<br>");
        out.println("contentPath"+contentPath+"<br>");
        out.println("remoteAddr"+remoteAddr+"<br>");
        out.println("</h1>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
