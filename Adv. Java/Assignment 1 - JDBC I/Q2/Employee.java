import java.sql.*;

public class Employee {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "varamyr");

            Statement stmt = connection.createStatement();

            boolean x = stmt.execute(
                    "CREATE TABLE employee(empid integer primary key auto_increment, empname varchar(30), salary integer)");

            if (!x) {
                System.out.println("Table created successfully");
            } else {
                System.out.println("Error");
            }

        } catch (SQLException se) {
            System.out.println(se);
        } catch (ClassNotFoundException ce) {
            System.out.println(ce);
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {
                System.out.println(se);
            }
        }

    }

}
