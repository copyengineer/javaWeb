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
		String parameter = request.getParameter("remenber");
		String parameter1 = request.getParameter("username");
		String parameter2 = request.getParameter("password");
		
		if(parameter1 == null || (!parameter1.equals(parameter2) && !parameter1.equals(""))){//如果用户名不等于密码，或者不登陆直接访问该页面，则重定向
			response.sendRedirect("login.jsp");
		}else if(parameter!=null && parameter.equals("on")){//如果用户勾选了记住用户名和密码,parameter!=null必须放在前面，不然可能发生异常
			Cookie cookie1 = new Cookie("username",parameter1);
			Cookie cookie2 = new Cookie("password",parameter2);
			cookie1.setMaxAge(24*60*60*7);//七天内免登陆
			cookie2.setMaxAge(24*60*60*7);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}else{
			Cookie[] cs = request.getCookies();
			if(cs !=null && cs.length != 0){
				for(Cookie c : cs){
					if(c.getName().equals("username")){
						c.setMaxAge(-1);
						response.addCookie(c);
					}else if(c.getName().equals("password")){
						c.setMaxAge(-1);
						response.addCookie(c);
					}
				}
			}
		}
		
	%>
	<h1>欢迎登陆</h1>
</body>
</html>