<%@ page errorPage="Error.jsp" %>
<%! float num1, num2; %>
<%! String radio; %>

<% num1 = Integer.parseInt(request.getParameter("n1"));
   num2 = Integer.parseInt(request.getParameter("n2"));
   radio = request.getParameter("arithmetic");

   if(radio.equals("add")){
%>
	<h2><%="Addition: " + (num1 + num2) %></h2>
	<a href="Arithmetic.html">Back</a>
<% 
	}else if(radio.equals("sub")){
%>
	<h2><%="Addition: " + (num1 - num2) %></h2>
	<a href="Arithmetic.html">Back</a>
<%
	}else if(radio.equals("mult")){
%>
	<h2><%="Multiplication: " + (num1 * num2) %></h2>
	<a href="Arithmetic.html">Back</a>
<%
	}else if(radio.equals("div")){
		if(num2 != 0){
%>
			<h2><%="Division: " + (num1 / num2) %></h2>
			<a href="Arithmetic.html">Back</a>
<%		}else{
		throw new Exception("Divide by zero");
		}
	}
%>