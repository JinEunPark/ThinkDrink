package forward;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FrontServlet", value = "/FrontServlet")
public class FrontServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int randomValue =  (int)(Math.random()*6)+1;
        req.setAttribute("dice",randomValue);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/NextServlet");
        requestDispatcher.forward(req, resp);
    }
}
