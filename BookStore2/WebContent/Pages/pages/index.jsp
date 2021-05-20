<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>网上书城</title>
    <base href="http://localhost:8080/demo/">
    <link rel="stylesheet" href="Pages/css/index.css">
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
                    <a class="active2" style="width: 66px;">全部作品</a>
                    <a>奇幻玄幻</a>
                    <a>武侠仙侠</a>
                    <a>历史军事</a>
                    <a>都市传说</a>
                    <a>科幻游戏</a>
                    <a>悬疑灵异</a>
                    <a>竞技同人</a>
                    <a>评论文集</a>
                    <a>二次元</a>
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
                    <a style="width: 39px;" class="active2">全部</a>
                    <a>A</a>
                    <a>B</a>
                    <a>C</a>
                    <a>D</a>
                    <a>E</a>
                    <a>F</a>
                    <a>G</a>
                    <a>H</a>
                    <a>I</a>
                    <a>J</a>
                    <a>K</a>
                    <a>L</a>
                    <a>M</a>
                    <a>N</a>
                    <a>O</a>
                    <a>P</a>
                    <a>Q</a>
                    <a>R</a>
                    <a>S</a>
                    <a>T</a>
                    <a>U</a>
                    <a>V</a>
                    <a>W</a>
                    <a>X</a>
                    <a>Y</a>
                    <a>Z</a>
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
                    <h6>111</h6>
                </div>
            </div>
        </div>

        <div class="book">
            <c:forEach items="${requestScope.allBookInfo }" var="oneBook">
            	<div class="one_book">
                	<div class="preview_img">
                    	<img src="Pages/img/book.jpeg" alt="">
                	</div>
                	<div class="book_info">
                    	<div class="book_name">
                    		<a href="">药帝之都市重生</a>
                    	</div>
                    	<div class="book_link">
                        	<a href="" class="author">瓜宝</a>
                        	|
                        	<a href="" class="type_info">都市娱乐</a>
                        	|
                        	<span>连载中</span>
                        	<span>更新时间 10-01 08:06</span>
                    	</div>
                    	<div class="book_desc">
                        	虚无三界一代药帝苏少杭 ，自撰无上功法——《药帝传承》，本应受万人瞩目和敬仰，却意外死于同门手中。 这一天，苏少杭突然惊醒，他发现，自己竟然...... 人生格言:人生在世不称意，软的不行来硬的，硬的不行那就来更硬的
                    	</div>
                    	<div class="latest">
                        	最新章节：第五十八章：交手忍术
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
    
</body>
</html>