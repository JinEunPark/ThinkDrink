package com.example.demo4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApplicationServlet02", value = "/ApplicationServlet02")
public class ApplicationServlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ApplicationServlet02() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext application = getServletContext();
        try{
            int value = (int)application.getAttribute("value");
            value++;
            out.println("<h1>"+String.valueOf(value)+"</h1>" );

        }catch(NullPointerException e){
            out.println("<h2>value 값이 설정되지 않았습니다</h2>");
        }
    }


}
