import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class WelcomeBack extends HttpServlet {

    static int i = 1;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        int total = 0;
        PrintWriter out = res.getWriter();

        String k = String.valueOf(i);
        Cookie c = new Cookie("visited", k);

        res.addCookie(c);

        int j = Integer.parseInt(c.getValue());

        if (j == 1) {
            out.println("Welcome " + req.getRemoteAddr() + "<br>");
        } else {
            out.println("Welcome-back " + req.getRemoteAddr() + "<br>");
            total += 1;
            out.println(total);
        }
        i++;
    }
}