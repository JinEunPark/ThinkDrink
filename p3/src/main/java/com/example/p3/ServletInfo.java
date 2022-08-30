package com.example.p3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletInfo", value = "/ServletInfo")
public class ServletInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");//반드시 이 형식 고대로 갑시다
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>info</title></head>");
        out.println("<body>");

        StringBuffer url = request.getRequestURL();
        String uri = request.getRequestURI();
        String contentPath = request.getContextPath();
        String remoteAddr = request.getRemoteAddr();

        out.println("url"+url+"<br>");
        out.println("urI"+uri+"<br>");
        out.println("contentpath"+contentPath+"<br>");
        out.println("remoteAddr"+remoteAddr+"<br>");


        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
