<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>自己仿做的购物车网页</title>
		 <base href="http://localhost:8080/homework2/">
		<style>
			.goods_list{
				height: 1000px;
				
			}
			.goods_list ul{
				width: 1000px;
				margin: 0 auto;
				margin-top: 100px;
			}
			.goods_list ul li{
				float: left;
				width: 240px;
				list-style: none;
				
			}
			.goods_list ul li img{
				margin-left: 20px;
			}
			.goods_list ul li p{
				text-align: center;
			}
			.goods_list ul li p a{
				display: inline-block;
				width:80px;
				height:30px;
				background:red;
				color:#fff;
				line-height:30px;
				font-size:12px;
				border-radius: 5px;
				margin-left: 10px;
				cursor:pointer;
			}
		</style>
		<style>
			.shopingCar{
				width: 350px;
				height:100%;
				position: fixed;
				top: 0;
				right:-310px;
				background: green;
			}
			.kuangk{
				width: 40px;
				height: 100%;
				background:#000;
				position:relative;
				float:left;
			}
			.kuangk a{
				color: #FFFFFF;
				font-size: 12px;
				width:12px;
				position:absolute;
				display:block;
				background: red;
				top:50%;
				left:0;
				padding:10px 14px;
				margin-top:-42px;
				cursor:pointer;
			}
		</style>
        <script type="text/javascript">
        
        	function mycar(){
        		location="shopping/car.jsp";
        	}
        
        </script>
	</head>
	<body>
	<%
		out.print(session.getAttribute("car"));
		out.print(session.getAttribute("count"));
		out.print(session.getId());

	%>
	<div style="width:100px;height:50px;margin:0px auto;background:red;color:white;text-align:center;line-height:50px" onclick="mycar()">
		我的购物车
	</div>
	
		<div class="goods_list">
			<ul>
				<li>
					<img src="shopping/1.jpg" alt="花" width="200px" height="200px" />
					<p class="top_name">算法竞赛入门经典</p>
					<p><span>￥200.0</span><a href="addToCar?name=算法竞赛入门经典&price=200">加入购物车</a></p>
				</li>
				<li>
					<img src="shopping/2.jpg" alt="花" width="200px" height="200px"/>
					<p class="top_name">python入门经典</p>
					<p><span>￥300.0</span><a href="addToCar?name=python入门经典&price=300">加入购物车</a></p>
				</li>
				<li>
					<img src="shopping/3.jpg" alt="花" width="200px" height="200px"/>
					<p class="top_name">Java</p>
					<p><span>￥250.0</span><a href="addToCar?name=java&price=250">加入购物车</a></p>
				</li>
				<li>
					<img src="shopping/4.jpg" alt="花" width="200px" height="200px"/>
					<p class="top_name">C和指针</p>
					<p><span>￥100.0</span><a href="addToCar?name=C和指针&price=100">加入购物车</a></p>
				</li>
			</ul>
			<ul>
				<li>
					<img src="shopping/1.jpg" alt="花" width="200px" height="200px"/>
					<p class="top_name">算法竞赛入门经典</p>
					<p><span>￥200.0</span><a>加入购物车</a></p>
				</li>
				<li>
					<img src="shopping/2.jpg" alt="花" width="200px" height="200px"/>
					<p class="top_name">python入门经典</p>
					<p><span>￥200.0</span><a>加入购物车</a></p>
				</li>
				<li>
					<img src="shopping/3.jpg" alt="花" width="200px" height="200px"/>
					<p class="top_name">Java</p>
					<p><span>￥200.0</span><a>加入购物车</a></p>
				</li>
				<li>
					<img src="shopping/4.jpg" alt="花" width="200px" height="200px"/>
					<p class="top_name">C和指针</p>
					<p><span>￥200.0</span><a>加入购物车</a></p>
				</li>
			</ul>
		</div>
      
        
       
        <script>
        	
        </script>
	</body>
</html>