<%@ page errorPage = "Error.jsp" %>
<%! String op;
 	float n1, n2, ans; 
%>

<%
	op = request.getParameter("arithmetic");
	n1 = Integer.parseInt(request.getParameter("n1"));
	n2 = Integer.parseInt(request.getParameter("n2"));
	switch(op){
		case "add":
				ans = n1 + n2;
				op = "Addition: " + (ans) + ".";
				break;
		case "sub":
				ans = n1 - n2;
				op = "Subtraction: " + (ans) + ".";
				break;
		case "mult":
				ans = n1 * n2;
				op = "Multiplication: " + (ans) + ".";
				break;
		case "div":
				if(n2 == 0){
					op = "Error: Cannot divide by zero";
					break;
				}
				ans = n1 / n2;
				op = "Division:  " + (ans) + ".";
				break;
	}
%>

<h1 style="margin: 40px"><%= op %></h1>
<a style="margin: 40px" href="Arithmetic.html">Back</h1>