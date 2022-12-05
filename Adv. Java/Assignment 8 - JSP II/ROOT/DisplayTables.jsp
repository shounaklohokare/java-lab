<%@ page errorPage="Error.jsp" %>
<%@ page session="false"%>
<%@ page import="java.sql.*" %>

<%! Connection conn;
    DatabaseMetaData dmb;
	ResultSet rs;	
%>
<html>
<head>
	<style>
		table{
			margin : 60px;
			border-collapse: collapse;
			padding: 5px;
		}

		td{
			padding: 5px;
			text-align: center;
		}

		h4{
			padding: 7px;
			margin: 60px;
		}
	</style>
</head>
<%

	Class.forName("com.mysql.cj.jdbc.Driver");

	conn = DriverManager.getConnection("jdbc:mysql://localhost:/practice", "root", "varamyr");

	dmb = conn.getMetaData();

	rs = dmb.getTables(null, null, null, new String[] {"TABLE"});
%>
<body>


	<h4>Database Product Name:- <%out.println(dmb.getDatabaseProductName());%></h4>
	<h4>Username:- <%out.println(dmb.getUserName());%></h4>
	<h4>Driver name:- <%out.println(dmb.getDriverName());%></h4>
	<h4>Driver version:- <%out.println(dmb.getDriverVersion());%></h4>
	<h4>Driver major version:- <%out.println(dmb.getDriverMajorVersion());%></h4><br>





	<table border=2>
		<tr>
			<th>Table Name</th>
		</tr>
	<% while(rs.next()){  %>
		<tr>
			<td><%  out.println(rs.getString("TABLE_NAME"));   %></td>
		</tr>
	<% }  %>
</table>
</body>
</html>