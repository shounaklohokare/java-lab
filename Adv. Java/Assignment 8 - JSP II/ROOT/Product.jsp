<%@ page import = "java.sql.*" %>
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
			margin-left: 57px;
			margin-top: 30px;
			margin-bottom: 0;
			font-weight: bold;
		}

	</style>
</head>

<%

	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn;

	try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:/practice", "root", "varamyr");


		String q = "SELECT * FROM product";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(q);

%>
 <body>
 		<p>Details of products</p>
		<table border="2">
			<tr>
				<td>Product ID</td>
				<td>Product Name</td>
				<td>Product Price</td>
			</tr><br>
				
			<%
				while(rs.next()){
			%>
			<tr>
				<td><% out.println(rs.getInt("pid")); %></td>
				<td><% out.println(rs.getString("pname")); %></td>
				<td><% out.println(rs.getString("pprice")); %></td>
			</tr>
			<%
				}
			%>
			
		</table>
</body>
<%
}catch(Exception e){
	System.out.println(e);
}
%>
