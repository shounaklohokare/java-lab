<%@ page errorPage ="Error.jsp" %>
<%@ page import ="java.util.*" %>
<%@ page import ="java.text.*" %>
<%! String name, greet; %>
<%! Date d; %>
<%! SimpleDateFormat sdf; %>
<%! int hr; %>

<%
	sdf = new SimpleDateFormat("H");
	d = new Date();
	int hr = Integer.parseInt(sdf.format(d));

	if(hr >= 0 && hr < 12){
		greet = "Morning";
	}else if(hr >= 12 && hr < 4){
		greet = "Afternoon";
	}else if(hr >= 4 && hr < 8){
		greet = "Evening";
	}else{
		greet = "Night";
	}

	name = request.getParameter("name");


%>

<h1 style="margin: 40px;"><%= "Good " + greet + " " + name %></h1>