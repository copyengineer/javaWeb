<%@page import="bean.user"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#ipt").focus(function(){
		//img标签的src属性值一改变浏览器就会重新向新的地址发请求
		
	});
});
</script>
</head>
<body>
	<!--用户在登录页面（login.jsp）中输入用户名和密码，让用户选择“是否记住用户名”。
	如果用户名和密码相符（用户名等于密码），则登录成功，进入欢迎页面（welcome.jsp）。
	在登录时，如果保存了登录状态，下次登录时若访问登录页面，则用户无需自己输入用户名和密码，进入欢迎页面。
	如果用户没有经过登录就访问欢迎页面，则跳转到登录页面-->
	<%
		String username = "";
		String password = "";
		Cookie[] cs = request.getCookies();
		if(cs !=null && cs.length != 0){
			for(Cookie c : cs){
				if(c.getName().equals("username")){
					username = c.getValue();
				}else if(c.getName().equals("password")){
					password = c.getValue();
				}
			}
		}
		
	%>
		
	<form action="../remenber_user" method="post">
		账号<input list="source" id="ipt" name="username" value=<%=((user)(session.getAttribute("now_user")))==null?"":((user)(session.getAttribute("now_user"))).getUsername() %>>
			<datalist id="source">
				<c:forEach items="${acount_info }" var="user">
					<option value="${user.getUsername() }">
				</c:forEach>
			</datalist>
		<div>密码：<input type="password" name="password" value=<%=((user)(session.getAttribute("now_user")))==null?"":((user)(session.getAttribute("now_user"))).getPassword() %>></div>
		<div>七天免登陆：<input type="checkbox" name="remenber"></div>
		<input type="submit" value="提交">
	</form>
	 <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</body>
</html>