import java.sql.*;

class EmployeeMetaData {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "varamyr");

            Statement stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM Employee");

            ResultSetMetaData rsmd = rs.getMetaData();

            int noOfCols = rsmd.getColumnCount();
            for (int i = 1; i <= noOfCols; i++) {
                System.out.println("\nColumn number :- " + i);
                System.out.println("Column Name:- " + rsmd.getColumnName(i));
                System.out.println("Column Type:- " + rsmd.getColumnTypeName(i));
                System.out.println("Column Size:- " + rsmd.getColumnDisplaySize(i));
            }

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

    }

}