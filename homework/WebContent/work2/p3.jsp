<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	out.print("这是p3,p1页面传过来的值为：" + request.getAttribute("num3"));
	%>
	<img alt="这是图片" src="reg_bg_min.jpg" style="width:<%=request.getAttribute("num3")%>px;height:<%=request.getAttribute("num3")%>px;display:block">
</body>
</html>