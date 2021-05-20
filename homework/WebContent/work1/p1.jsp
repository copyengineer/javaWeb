<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function cube(j){
		var result = j*j*j;
		location = "p2.jsp?result=" + result;
	}


</script>
<style type="text/css">
	a{
		cursor:pointer;
	
	}

</style>
</head>
<body>
	<%
		for(int i=1;i<=50;i++){
	%>
			<%
				out.print("<a onclick='cube("+i+")'>"+i+"</a>");
			%>
	
	<%} %>
	

	
</body>
</html>