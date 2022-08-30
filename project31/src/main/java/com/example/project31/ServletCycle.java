package com.example.project31;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCycle", value = "/ServletCycle")
public class ServletCycle extends HttpServlet {

    public ServletCycle (){
        System.out.println("ServletCycle made");
    }
    @Override
    public void init() throws ServletException {
        System.out.println("init call");
    }

    @Override
    public void destroy() {
        System.out.println("destroy call");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("service call");
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello");//service 메소드가 오버라이딩 되지 않기 때문에 doget 에벤트가 실행되면 이 메소드가 실행된다.
        response.setContentType("text/html");//html text type의 객체를 받겠다는 의미
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");
        out.println("<form method='post' action='/project31_war_exploded/ServletCycle'>");//action을 사용하면 해당 url로 post value를 전송한다.
        out.println("name : <input type='text' name='name'><br>");
        out.println("<input type='submit' value='ok'><br>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        out.println("<h1> hello " + name + "</h1>");
        out.close();
    }

}
