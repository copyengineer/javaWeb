<%@page import="com.sun.xml.internal.ws.wsdl.writer.document.Types"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>网上书城</title>
    <base href="http://localhost:8080/BookStore6/">
    <link rel="stylesheet" href="Pages/css/index.css">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>

    <div class="main">
        <div class="head">
            <div class="head_top">
                <img src="Pages/img/logo.png" alt="" class="logo">
                <input type="text" class="search">
                <input type="submit" class="search_btn" value="">
                <div class="login_register_recharge">
                    <a href="" class="recharge">充值</a>
                    <a href="" class="login">登陆</a>
                    <a href="" class="register">注册</a>
                </div>
            </div>
        </div>
		
		
        <div class="type">
            <div class="content">
                <div class="sex_type">
                    <a href="" class="boy_type active">男生频道</a>
                    <span>|</span>
                    <a href="" class="gril-type">女生频道</a>
                </div>
                <div class="book_type kind">
                    <div class="type_name">作品分类:</div>
                    <a id="a0" style="width: 66px;" onclick="changeType(0)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"active2":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("全部作品")?"active2":"") %>>全部作品</a>
                    <a id="a1" onclick="changeType(1)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("奇幻玄幻")?"active2":"") %>>奇幻玄幻</a>
                    <a id="a2" onclick="changeType(2)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("武侠仙侠")?"active2":"") %>>武侠仙侠</a>
                    <a id="a3" onclick="changeType(3)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("历史军事")?"active2":"") %>>历史军事</a>
                    <a id="a4" onclick="changeType(4)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("都市娱乐")?"active2":"") %>>都市娱乐</a>
                    <a id="a5" onclick="changeType(5)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("科幻游戏")?"active2":"") %>>科幻游戏</a>
                    <a id="a6" onclick="changeType(6)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("悬疑灵异")?"active2":"") %>>悬疑灵异</a>
                    <a id="a7" onclick="changeType(7)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("竞技同人")?"active2":"") %>>竞技同人</a>
                    <a id="a8" onclick="changeType(8)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("评论文集")?"active2":"") %>>评论文集</a>
                    <a id="a9" onclick="changeType(9)" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByType")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByType").equals("二次元")?"active2":"") %>>二次元</a>
                </div>
                <div class="write_schedule kind">
                    <div class="type_name">写作进度:</div>
                    <a class="active2">全部</a>
                    <a>连载中</a>
                    <a>已完结</a>
                </div>
                <div class="word_num kind">
                    <div class="type_name">作品字数:</div>
                    <a style="width: 39px;" class="active2">全部</a>
                    <a>30万字以下</a>
                    <a>30-50万</a>
                    <a>50万-100万</a>
                    <a>100万-200万</a>
                    <a>200万以上</a>
                </div>
                <div class="update_time kind">
                    <div class="type_name">更新时间:</div>
                    <a class="active2">全部</a>
                    <a>三日内</a>
                    <a>七日内</a>
                    <a>半月内</a>
                    <a>一月内</a>
                </div>
                <div class="first_word kind">
                    <div class="type_name">书名首字母:</div>
                    <a onclick="change_firstword(title)" title="全部" style="width: 39px;margin-left:7px" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"active2":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("全部")?"active2":"") %>>全部</a>
                    <a onclick="change_firstword('a')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("a")?"active2":"") %>>A</a>
                    <a onclick="change_firstword('b')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("b")?"active2":"") %>>B</a>
                    <a onclick="change_firstword('c')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("c")?"active2":"") %>>C</a>
                    <a onclick="change_firstword('d')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("d")?"active2":"") %>>D</a>
                    <a onclick="change_firstword('e')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("e")?"active2":"") %>>E</a>
                    <a onclick="change_firstword('f')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("f")?"active2":"") %>>F</a>
                    <a onclick="change_firstword('g')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("g")?"active2":"") %>>G</a>
                    <a onclick="change_firstword('h')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("h")?"active2":"") %>>H</a>
                    <a onclick="change_firstword('i')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("i")?"active2":"") %>>I</a>
                    <a onclick="change_firstword('j')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("j")?"active2":"") %>>J</a>
                    <a onclick="change_firstword('k')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("k")?"active2":"") %>>K</a>
                    <a onclick="change_firstword('l')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("l")?"active2":"") %>>L</a>
                    <a onclick="change_firstword('m')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("m")?"active2":"") %>>M</a>
                    <a onclick="change_firstword('n')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("n")?"active2":"") %>>N</a>
                    <a onclick="change_firstword('o')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("o")?"active2":"") %>>O</a>
                    <a onclick="change_firstword('p')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("p")?"active2":"") %>>P</a>
                    <a onclick="change_firstword('q')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("q")?"active2":"") %>>Q</a>
                    <a onclick="change_firstword('r')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("r")?"active2":"") %>>R</a>
                    <a onclick="change_firstword('s')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("s")?"active2":"") %>>S</a>
                    <a onclick="change_firstword('t')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("t")?"active2":"") %>>T</a>
                    <a onclick="change_firstword('u')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("u")?"active2":"") %>>U</a>
                    <a onclick="change_firstword('v')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("v")?"active2":"") %>>V</a>
                    <a onclick="change_firstword('w')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("w")?"active2":"") %>>W</a>
                    <a onclick="change_firstword('x')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("x")?"active2":"") %>>X</a>
                    <a onclick="change_firstword('y')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("y")?"active2":"") %>>Y</a>
                    <a onclick="change_firstword('z')" class=<%=((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord")==null?"":(((Map<String,String>)request.getAttribute("live")).get("getBookByFirstWord").equals("z")?"active2":"") %>>Z</a>
                </div>
                <div class="other kind">
                    <div class="type_name">其他:</div>
                    <a class="active2">全部</a>
                    <a>免费</a>
                    <a>VIP</a>
                </div>
                <div class="cut_line" style="margin: 5px auto;height: 1px;background: #e6e6e6;"></div>
                <div class="selected">
                    <div class="type_name" style="line-height: 32px;">已选条件:</div>
                    <%!List<String> list; %>
                    <%
                    	Object o =request.getAttribute("live");
                    	list = new ArrayList<String>();
                    	if(o instanceof Map<?,?>){
                    		Map<String,String> m = (Map<String,String>)o;
                    		Collection<String> c =m.values();
                    		
                    		for(String s:c){
                    			if(s.equals("全部") || s.equals("全部作品")){
                    				
                    			}else{
                    				list.add(s);
                    			}
                    		}
                    	}
                    	request.setAttribute("t", list);
                    
                    %>
                    <h6>
                    	<c:forEach items="${requestScope.t }" var="types">
                    		<span>${types }</span>
                    
                    	</c:forEach>
                    </h6>
                </div>
            </div>
        </div>

        <div class="book">
            <c:forEach items="${requestScope.allBookInfo }" var="oneBook" end="11">
            	<div class="one_book">
                	<div class="preview_img">
                    	<img src="Pages/img/${oneBook.getBook_img() }.jpeg" alt="">
                	</div>
                	<div class="book_info">
                    	<div class="book_name">
                    		<a href="">${oneBook.getBook_name() }</a>
                    	</div>
                    	<div class="book_link">
                        	<a href="" class="author">${oneBook.getBook_author() }</a>
                        	|
                        	<a href="" class="type_info">${oneBook.getBook_type() }</a>
                        	|
                        	<span>连载中</span>
                        	<span>更新时间 10-01 08:06</span>
                    	</div>
                    	<div class="book_desc">
                        	${oneBook.getBook_preview() }
                    	</div>
                    	<div class="latest">
                        	${oneBook.getBook_latest() }
                    	</div>
                	</div>
            	</div>
            </c:forEach>
            
            <div class="page_choice" style="float: left;">
                <a href="">1</a>
                <a href="">2</a>
                <a href="">3</a>
                <a href="">4</a>
                <a href="">5</a>
                <a href="">6</a>
                <em>...</em>
                <a href="">999</a>
                <a href="">></a>
                跳转到：
                <input type="text" value="1">/999页
                <input type="button" value="跳转" style="background: #fff;width: 40px;">

            </div>
        </div>

    </div>
    <script type="text/javascript" src="Pages/js/index.js"></script>
    <script type="text/javascript">
    var list = $('div.book_type a');
    	console.log(list);
    
    
    
    
    
    </script>
</body>
</html>