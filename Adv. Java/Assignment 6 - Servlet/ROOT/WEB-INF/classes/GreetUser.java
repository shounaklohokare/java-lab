import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.text.*;
import java.util.*;

public class GreetUser extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        PrintWriter out = res.getWriter();

        res.setContentType("text/html");

        out.println("<h1> Welcome " + username + "</h1>");

        Date dt = new Date();

        SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh-mm-ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("H");

        out.println("<br>Date: " + sdf1.format(dt));
        out.println("<br>Time: " + sdf2.format(dt));

        int tm = Integer.parseInt(sdf3.format(dt));

        if (tm > 6 && tm < 12) {
            out.println("<br>Good Morning: " + username);
        } else if (tm >= 12 && tm < 16) {
            out.println("<br>Good Afternoon: " + username);
        } else if (tm >= 16 && tm < 21) {
            out.println("<br>Good Evening: " + username);
        } else {
            out.println("<br>Good Night: " + username);
        }

        out.println("<br><a href=GreetUser.html>Go Back</a>");
        out.close();
    }

}