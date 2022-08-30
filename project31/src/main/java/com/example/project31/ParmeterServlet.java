package com.example.project31;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ParmeterServlet", value = "/Parma")
public class ParmeterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //내가 꺼내올 정보들은 request객체에서 꺼내고 내가 응답으로 보낼 정보들은 response 객체에 담는다.
        response.setContentType("text/html");//객체에게 input type를 넘겨줌
        PrintWriter out = response.getWriter();//클라이언트에게 연결통로를 열어줌
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");

        String name = request.getParameter("name");//doget의 URL로 넘어온 사용자의 이름과 사용자의 나이를 들고옴
        String age = request.getParameter("age");
        out.println("name:"+name+"<br>");
        out.println("age:"+age+"<br>");

        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
