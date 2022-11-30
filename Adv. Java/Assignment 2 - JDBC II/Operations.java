import java.sql.*;
import java.util.*;
import java.io.*;

class Operations {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps;
        Statement stmt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver found");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/practice", "root", "varamyr");
            System.out.println("Connection found");

            ArrayList al = new ArrayList();

            String q = "SELECT * FROM Employee";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                al.add(rs.getInt(1));
            }

            int op = -1;
            while (true) {

                System.out.print("\n__________MAIN MENU_____________");
                System.out.print("\n1. Insert");
                System.out.print("\n2. Delete");
                System.out.print("\n3. Display");
                System.out.print("\n4. Exit");

                System.out.print("\nEnter your option: ");

                op = Integer.parseInt(br.readLine());

                switch (op) {

                    case 1:
                        q = "INSERT INTO Employee VALUES(?, ?, ?)";

                        ps = conn.prepareStatement(q);

                        System.out.print("\nEnter employee id: ");
                        int empid = Integer.parseInt(br.readLine());

                        if (!al.contains(empid)) {
                            al.add(empid);
                            ps.setInt(1, empid);

                            System.out.print("\nEmployee name: ");
                            String empname = br.readLine();
                            ps.setString(2, empname);

                            System.out.print("\nEmoloyee salary: ");
                            int sal = Integer.parseInt(br.readLine());

                            ps.setInt(3, sal);

                            int x = ps.executeUpdate();

                            if (x > 0)
                                System.out.println("Record added successfully\n");

                            else
                                System.out.println("Recorded not add");

                        } else {
                            System.out.println("Employee id already exists");
                        }
                        ps.close();
                        stmt.close();
                        break;

                    case 2:
                        System.out.print("\nEnter employee id: ");
                        int id = Integer.parseInt(br.readLine());

                        String qry = "SELECT * FROM Employee";
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(qry);
                        boolean deleted = false;
                        while (rs.next()) {
                            int del_id = rs.getInt(1);

                            if (id == del_id) {
                                String qr = "DELETE FROM Employee WHERE empid='" + id + "'";
                                ps = conn.prepareStatement(qr);
                                ps.executeUpdate();

                                deleted = true;
                                ps.close();
                                al.remove(Integer.valueOf(id));
                                System.out.println("Deletion successful");
                                break;
                            }
                        }

                        if (!deleted)
                            System.out.println("No Record found with this id");

                        stmt.close();
                        break;

                    case 3:
                        String qr = "SELECT * FROM Employee";
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(qr);
                        System.out.println("\nEmpid\tEmpname\tSalary");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
                        }
                        stmt.close();
                        break;

                    case 4:
                        System.exit(0);

                    default:
                        System.out.println("Invalid Option. Please try again!!");
                }
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            try {
                conn.close();
            } catch (SQLException se) {
                System.out.println(se);
            }

        }

    }

}