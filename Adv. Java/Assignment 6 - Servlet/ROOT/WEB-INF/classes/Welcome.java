import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Welcome extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            res.setContentType("text/html");

            PrintWriter out = res.getWriter();

            HttpSession session = req.getSession(false);

            String n = (String) session.getAttribute("username");

            out.println("<h1>Welcome :- " + n + "</h1>");

            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
