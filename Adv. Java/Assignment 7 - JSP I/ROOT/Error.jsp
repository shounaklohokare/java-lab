<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<h2>Error: Exception Occured</h2>
	<h4>Exception details: <%= exception.getMessage() %></h4>
	<a href="Arithmetic.html">Back</a>
</body>
</html>