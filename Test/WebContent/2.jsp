<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>hello</h1>
	<%
		request.getRequestDispatcher("4.jsp").forward(request, response);
	
	%>
	<a href="4.jsp">made</a>
</body>
</html>