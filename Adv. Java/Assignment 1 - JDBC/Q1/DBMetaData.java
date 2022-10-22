import java.sql.*;

class DBMetaData {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection cn = null;
        java.sql.ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("\nDriver Found");

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "varamyr");

            DatabaseMetaData db = cn.getMetaData();

            System.out.println("\nDatabase Product Name: " + db.getDatabaseProductName());
            System.out.println("\nUser name: " + db.getUserName());
            System.out.println("\nDatabase Driver Name: " + db.getDriverName());
            System.out.println("\nDatabase Driver version: " + db.getDriverVersion());
            System.out.println("\nDatabase Driver Major version: " + db.getDriverMajorVersion());

            rs = db.getTables(null, null, null, new String[] { "TABLE" });
            System.out.println("\nTables in Database: ");
            while (rs.next()) {
                String tname = rs.getString("TABLE_NAME");
                System.out.println("Table: " + tname);
            }

        } catch (SQLException se) {
            System.out.println(se);
        } catch (ClassNotFoundException ce) {
            System.out.println(ce);
        } finally {
            try {
                cn.close();
            } catch (SQLException se) {
                System.out.println(se);
            }
        }

    }

}