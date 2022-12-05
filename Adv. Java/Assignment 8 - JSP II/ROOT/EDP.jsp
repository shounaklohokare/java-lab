<%@ page import="java.sql.*" %>
<html>
<head>
	<style>
		table{
			margin-left : 60px;
			margin-bottom: 60px;
			border-collapse: collapse;
			padding: 5px;
		}

		td{
			padding: 5px;
			text-align: center;
		}

		p{
			padding: 7px;
			margin-left: 60px;
			margin-top: 20px;
			margin-bottom: 0;
			font-weight: bold;
		}
	</style>
</head>
<%
	Connection conn;
	

	Class.forName("com.mysql.cj.jdbc.Driver");

	conn = DriverManager.getConnection("jdbc:mysql://localhost:/practice", "root", "varamyr");

	Statement stmt = conn.createStatement();

	String q = "SELECT * FROM employee WHERE eid IN (SELECT eid FROM project_employee WHERE pid = (SELECT pid FROM project WHERE pname = 'Inventory Control'))";


	ResultSet rs = stmt.executeQuery(q);
	

	
%>
	<body>
		<p>Employeees working on Inventory control project</p>
		<table border="2">
			<tr>
				<td>Employee Id</td>
				<td>Employee Name</td>
				<td>Department Id</td>
			</tr>
		<%	while(rs.next()){
		%>
			<tr>
				<td><% out.println(rs.getInt("eid")); %></td>
				<td><% out.println(rs.getString("ename")); %></td>
				<td><% out.println(rs.getInt("did")); %></td>
			</tr>
		<%
		}
		%>
		</table>

		<%

			q = "SELECT e.* FROM employee e INNER JOIN department d ON e.did = d.did WHERE dname='Computer'";

			Statement stmt2 = conn.createStatement();

			ResultSet rs2 = stmt2.executeQuery(q);
		%>
		<p>Employeees working in Computer Department</p>
		<table border="2">
			<tr>
				<td>Employee Id</td>
				<td>Employee Name</td>
				<td>Department Id</td>
			</tr>
		<%	while(rs2.next()){
		%>
			<tr>
				<td><% out.println(rs2.getInt("eid")); %></td>
				<td><% out.println(rs2.getString("ename")); %></td>
				<td><% out.println(rs2.getInt("did")); %></td>
			</tr>
		<%
		}
		%>
		</table>
	</body>