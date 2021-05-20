<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#img").click(function(){
		//img标签的src属性值一改变浏览器就会重新向新的地址发请求
		$(this).attr("src","code.jpg?t="+Math.random());
	});
});
</script>
</head>
<body>
	<%
		out.print(session.getAttribute("user"));
	%>
	<form action="login_servlet" method="post">
		<div>账号：<input type="text" name="username" value=${sessionScope.user.get(0) }></div>
		<div>密码：<input type="password" name="password" value=${sessionScope.user.get(1)}></div>
		<div>记住密码：<input type="checkbox" name="remenber"></div>
		<input type="submit" value="提交">
		验证码<input type="text" name="check_code"> <img alt="img" src="code.jpg"  id="img">
	</form>
</body>
</html>