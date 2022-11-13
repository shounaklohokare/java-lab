import java.sql.*;
import java.io.*;
import java.util.*;

class Operations
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection cn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		String qry,qry1;
		int count=0,del_id=0,flag=0,f=0;
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver found");
			
			cn = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221625","syca221625","");
			System.out.println("Connection found");
			
			ArrayList a = new ArrayList();
			qry1 = "select * from employee";
			stmt = cn.createStatement();
			rs = stmt.executeQuery(qry1);
			while(rs.next())
			{
				a.add(rs.getInt(1));
			}
			
			int ch;
			do
			{
				System.out.println("\nMenu\n1.Insert\n2.Delete\n3.Display\n4.Exit\n");
				System.out.print("Enter choice : ");
				ch = Integer.parseInt(br.readLine());
				
				switch(ch)
				{
					case 1: qry = "Insert into employee values (?,?,?)";
						ps = cn.prepareStatement(qry);
						
						System.out.print("\nEmployee Id : ");
						int empid = Integer.parseInt(br.readLine());
						if(!a.contains(empid))
						{
							a.add(empid);
							ps.setInt(1,empid);
			
							System.out.print("Employee Name : "); 
							String empname = br.readLine();
							ps.setString(2,empname);
							 
							System.out.print("Employee Salary : ");
							int salary = Integer.parseInt(br.readLine());
							ps.setInt(3,salary);
							int x = ps.executeUpdate();
						
							if(x>0)
								System.out.println("Record added successfully");
							else
								System.out.println("Record not added successfully");
						}
						else
							System.out.println("Employee Id already exist");
						ps.close();
						stmt.close();
						break;
						
					case 2: System.out.print("Enter employee id : ");
						int id = Integer.parseInt(br.readLine());
						
						qry = "select * from employee";
						stmt = cn.createStatement();
						rs = stmt.executeQuery(qry);
						while(rs.next())
						{
							del_id = rs.getInt(1);
							if(id==del_id)
							{
								qry1 = "delete from employee where empid='"+id+"'";
								ps = cn.prepareStatement(qry1);
								ps.executeUpdate();
								flag=1;
								ps.close();
								a.remove(Integer.valueOf(id));
								System.out.println("Record deleted successfully");
								break;
							}
						}
						if(flag==0)
							System.out.println("No record found with this id");
						
						stmt.close();
						flag=0;
						break;
						
					case 3: qry = "select * from employee";
						stmt = cn.createStatement();
						rs = stmt.executeQuery(qry);
						System.out.println("\nEmpid\tEmpname\tSalary");
						while(rs.next())
						{
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
						}
						stmt.close();
						break;
					default:if(ch!=4)
							System.out.println("\nInvalid choice, please enter above choice only");
				}
			}while(ch!=4);
		}
		catch(SQLException e)
		{	
			System.out.println(" "+e.getMessage());
		}
		catch(ClassNotFoundException ce) {}
		
		finally
		{
			try
			{
				cn.close();
			}
			catch(SQLException se) {}
		}
	}
}		
						
						
						
						
						
						
						
						
						
						
						
						
						
