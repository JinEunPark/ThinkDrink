package com.example.demo4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApplicationServlet01", value = "/ApplicationServlet01")
public class ApplicationServlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ApplicationServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();//출력을 위한 print 객체
        ServletContext application = getServletContext();//servlet 객체의 context를 통해서 객체를 얻어옴
        int value = 1;
        application.setAttribute("value",value);//application scope 영역에 값을 할당
        out.println("<h1> value:"+(value)+"</h1>");//출력
    }


}
