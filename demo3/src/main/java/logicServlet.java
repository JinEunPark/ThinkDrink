import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logicServlet", value = "/logicServlet")
public class logicServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int value1  = (int)(Math.random()*100)+1;
        int value2 = (int)(Math.random()*100)+1;
        int result = value1 + value2;
        req.setAttribute("value1",value1);
        req.setAttribute("value2",value2);
        req.setAttribute("result",result);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");//생성된 값을 dispathcher 값을 이용해서 뿌려준다.
        requestDispatcher.forward(req,resp);//servlet에서 생성된 req 객체와 resp객체를 넘겨준다.

    }
}
