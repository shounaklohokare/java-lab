import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");

        HttpSession session = req.getSession(true);

        if (authenticateUser(username, password)) {
            session.setAttribute("username", username);
            res.sendRedirect("http://localhost:8080/Welcome");
        } else {
            res.sendRedirect("http://localhost:8080/Error.html");
        }


    }

    static boolean authenticateUser(String username, String password) {

        Connection conn = null;
        boolean out = false;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "varamyr");

            PreparedStatement ps = conn.prepareStatement("select * from user where username=? and password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            out = rs.next();

        } catch (SQLException se) {
            System.out.println(se);
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } finally {
            try {
                conn.close();
            } catch (SQLException se) {
                System.out.println(se);
            }
        }

        return out;

    }

}
