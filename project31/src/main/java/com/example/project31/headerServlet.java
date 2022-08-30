package com.example.project31;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "headerServlet", value = "/header")
public class headerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");
        Enumeration<String> headerNames = request.getHeaderNames();//getheaderNames를 이용해서 헤더를 반환함
        while(headerNames.hasMoreElements()){//아직 객체를 가지고 있다면 반복문 실행
            String headerName = headerNames.nextElement();//가지고 있던 스트링 타입의 객체를 반환
            String headerValue = request.getHeader(headerName);//헤더의 이름에 대응하는 문자열 값을 반환함
            out.println(headerName +":"+ headerValue+"<br>");//헤더의 이름과 헤더의 값을 맵핑해서 반환함
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
