import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class WelcomeBack extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie[] cookiesFromClient = req.getCookies();

        int visitorCount = 0;

        Cookie cookie = new Cookie("visitor-count", "");
        String messageToClient = "";

        if (cookiesFromClient != null) {
            for (Cookie c : cookiesFromClient) {
                if (c.getName().equals("visitor-count")) {
                    visitorCount = Integer.parseInt(c.getValue());
                }
            }
        }

        cookie.setValue(Integer.toString(++visitorCount));
        res.addCookie(cookie);

        if (visitorCount <= 1) {
            messageToClient = "<h1> Welcome, " + req.getRemoteAddr() + "</h1>";
        } else {
            messageToClient = "<h1> Welcome back, " + req.getRemoteAddr() + "</h1>";
        }

        out.write(messageToClient);

    }
}