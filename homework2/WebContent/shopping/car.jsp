<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bean.book"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		
		<title></title>
		<base href="http://localhost:8080/homework2/">
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		<style>

			body{
	overflow: hidden;
	text-align: center;
	
}
.car{
	width:60%;
	border: 1px solid #F88020;
	border-radius: 18px;
	margin-left: 300px;
	
	
}
.car .good{
	background-color: #F88020;
	height:55px;
	font-size: 22px;
	color:white;
	line-height: 55px;
	font-weight: 200;
	border-radius: 18px 18px 0 0;
	margin-bottom: 20px;
	
}
.car .good table{
	width:100%;
}
.car .goods{
	height:45px;
	line-height: 45px;
	font-size: 20px;
	font-weight: 200;
}
.car .goods table{
	width:100%;
}
.car .goods table .btn1{
	width: 70px;
	height:28px;
	border: 2px solid #46B3E6;
	background-color: white;
	color: #46B3E6;
	border-radius: 4px;
	font-weight: 600;
}
.car .goods table button:hover{
	background-color: #46B3E6;
	color: white;
}
.car .goods1{
	margin-top: 10px;
	
	background-color: ;
	height:50px;
	font-size: 19px;
	color:white;
	line-height: 50px;
	font-weight: 200;
	border-radius:0 0 10px 10px ;
}
.car .goods2{
	border-top: 1px solid #F88020;
	margin-top: 10px;
	height:50px;
	font-size: 19px;
	line-height: 50px;
	font-weight: 200;
	border-radius:0 0 10px 10px ;
}
.car .goods1 table{
	
	width:100%;
}
.car .goods1 .btn2{
	width: 70px;
	height:28px;
	border: 2px solid #21BF73;
	background-color: white;
	color: #21BF73;
	border-radius: 4px;
	font-weight: 600;
}
.car .goods1 .btn2:hover{
	color:white;
	background-color: #21BF73;
}
.car .goods1 .btn3{
	width: 80px;
	height:30px;
	border: 2px solid #FF0000;
	background-color: white;
	color: #FF0000;
	border-radius: 4px;
	font-weight: 600;
}
.car .goods1 .btn3:hover{
	color:white;
	background-color:#FF0000 ;
}



		</style>
		<script type="text/javascript">
			function cl(){
				location = "clear_car";
			}	
			
			
			$(function(){
				
				$(".jian").click(function(){
					$.ajax({
						   type: "POST",
						   url: "jian",
						   data: "name="+$(".jian2").text(),
						   dataType:"json",
						   success: function(msg){
							   //alert(msg.nums);
							   location.reload();
						   }
					});
				});
				
				$(".jia").click(function(){
					$.ajax({
						   type: "POST",
						   url: "jia",
						   data: "name="+$(".jian2").text(),
						   dataType:"json",
						   success: function(msg){
							   //alert(msg.nums);
							   location.reload();
						   }
					});
				});
			})
			
		</script>
	</head>
	<body>
	<%
		out.print(session.getAttribute("car"));
		out.print(session.getAttribute("count"));
		Cookie[] c = request.getCookies();
		for (Cookie cookie : c) {
			if(cookie.getName().equals("JSESSIONID")) {
				cookie.setValue("123");//用户在不同的浏览器上登陆购物车信息都能同步，这个123可以是用户名，手机号等唯一的东西，用户需要访问购物车时必须登陆。
			}
		}
	%>
	<div class="car">
			
				<div class="good">
					<table><tr><td width=30%>商品名称</td><td width=20%>单价</td><td width=20%>数量</td><td width=30%>操作</td></tr></table>
				</div>
				<c:forEach items="${car }" var="b">
				
					<div class="goods">
						<table>
							<tr>
								<td width=30%>${b.key }</td>
								<td width=20%>${b.value.getPrice() }</td>
								<td width=20%>  <span style="display:inline-block;border:1px solid black;width:15px;height:15px;line-height:15px" class="jian">-<span style="display:none" class="jian2">${b.key }</span></span>   ${b.value.getNum() }   <span style="display:inline-block;border:1px solid black;width:15px;height:15px;line-height:15px" class="jia">+</span>  </td>
								<td width=30%><a><button class="btn1">删除</button></a></td>
							</tr>
						</table>
					</div>
				</c:forEach>
				<div class="goods2">
					<table><tr><td width=560></td><td width=20%>商品件数：${count }</td><td>总价：${cost }</td></tr></table>
				</div>
				<div class="goods1">
					<table>
						<tr>
							<td width=50%>
								<button class="btn2">确认购买</button>
							</td>
							<td>
								<button class="btn3" onclick="cl()" type="submit">全部清空</button>
							</td>
						</tr>
					</table>
				</div>
		</div>
		
	</body>
</html>