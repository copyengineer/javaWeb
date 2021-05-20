<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--编写4个JSP页面：p1.jsp、p2.jsp、p3.jsp和error.jsp。要求：
（1）用户在p1.jsp页面中输入一个500-800之间的整数，并提交给该页面。如果输入的数在500-600之间就跳转到p2.jsp，如果在600-800之间就跳转到p3.jsp。如果输入数据不合法就跳转到error.jsp。
（2）p2.jsp、p3.jsp能输出p1.jsp传递过来的值，并显示一副图像，该图像的高和宽设置为传递过来的值。error.jsp页面能显示错误信息和一副图像。
	-->
	<form action="p1.jsp" method="post">
		请输入一个数字<input type="text" name="number">
		<input type="submit">
	</form>
	<%
		String num = request.getParameter("number");
		if(num !=null){
			int nb = Integer.parseInt(request.getParameter("number"));//这里可以使用try-catch语句来捕捉异常，防止用户输入非数字
			if(nb < 600 && nb>=500){
				request.setAttribute("num2", nb);
				request.getRequestDispatcher("p2.jsp").forward(request, response);
			}else if(nb < 800 && nb>=600){
				request.setAttribute("num3", nb);
				request.getRequestDispatcher("p3.jsp").forward(request, response);
			}else{
				request.setAttribute("num4", nb);
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	%>
</body>
</html>