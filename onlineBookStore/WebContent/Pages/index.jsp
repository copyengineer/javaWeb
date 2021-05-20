<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>网上图书商店</title>
    <link rel="stylesheet" href="/onlineBookStore/Pages/css/index.css">
    <script>
        function c(id,title){
           var a = document.getElementById(id);
           if(a.value==title){
               a.value="";
           }
        }
        function c1(id,value){
           var a = document.getElementById(id);
           if(a.value==""){
               a.value=value;
               console.log(12);
           }
        }
    </script>
</head>
<body>
    <div class="login">
        <h3 class="read">用阅读</h3>
        <p class="change">改变我们的一生</p>

        <div class="choice">
            <ul class="tab">
                <li class="active" id="f1" style=" border-radius: 20px 20px 0px 0px;user-select: none;background:<%= request.getAttribute("sty2")==null?"#E0ECF8":"#fff" %>">登陆</li>
                <li id="f2" style=" border-radius: 20px 20px 0px 0px;user-select: none;background:<%= request.getAttribute("sty2")==null?"#fff":"#E0ECF8" %>">注册</li>
            </ul>
            
            <div class="tab1" style="display:<%=request.getAttribute("sty")!=null?"none":"block" %>">
                <form action="/onlineBookStore/loginServlet" method="get">
                    <p id="c1" style="position: absolute;top: 60px;height: 30px;text-align: center;line-height: 30px;width: 480px;color: red;"><%=request.getAttribute("msg")==null?"欢迎登陆":request.getAttribute("msg") %></p>
                    <dl class="dl1">
                        <dt>用户名</dt>
                        <dd>
                            <input id="id1" title="请输入用户名" type="text" value="请输入用户名" onclick="c(id,title)" onblur="c1(id,title)" name="username">
                        </dd>
                    </dl>
                    <dl class="dl2">
                        <dt>手机号</dt>
                        <dd>
                            <input type="text" title="请输入手机号" value="请输入手机号" onclick="c(id,title)" id="id2" onblur="c1(id,title)" name="phone">
                        </dd>
                    </dl>
                    <dl class="dl3">
                        <dt>密      码</dt>
                        <dd>
                            <input type="text" title="请输入密码" value="请输入密码" onclick="c(id,title)" id="id3" onblur="c1(id,title)" name="password">
                        </dd>
                    </dl>
                    <button style="position: absolute;top: 400px;left:20px ;width: 440px;height: 50px;background: #BDCEFC;color: #fff;border-radius: 25px;cursor: pointer;border-style: none;">立即登陆</button>
                </form>
            </div>
            <div class="tab2" style="display: <%=request.getAttribute("sty")==null?"none":"block" %>;">
                <p id="c2" style="position: absolute;top: 60px;height: 30px;text-align: center;line-height: 30px;width: 480px;color: red;"><%=request.getAttribute("msg2")==null?"欢迎注册":request.getAttribute("msg2") %></p>
                <form action="/onlineBookStore/register" method="get">
                    <dl class="dl1">
                        <dt>用户名</dt>
                        <dd>
                            <input type="text" value="请输入用户名" id="id11" title="请输入用户名" onclick="c(id,title)" onblur="c1(id,title)" autocomplete="on" name="username">
                        </dd>
                    </dl>
                    <dl class="dl2">
                        <dt>手机号</dt>
                        <dd>
                            <input type="text" value="请输入手机号" id="id22" title="请输入手机号" onclick="c(id,title)" onblur="c1(id,title)" name="phone">
                        </dd>
                    </dl>
                    <dl class="dl3">
                        <dt>密      码</dt>
                        <dd>
                            <input type="text" value="请输入密码" id="id33" title="请输入密码" onclick="c(id,title)" onblur="c1(id,title)" name="password">
                        </dd>
                    </dl>
                    <dl class="dl4">
                        <dt>确认密码</dt>
                        <dd>
                            <input type="text" value="请再次输入密码" id="id44" title="请再次输入密码" onclick="c(id,title)" onblur="c1(id,title)" name="passwordagain">
                        </dd>
                    </dl>
                    <button style="position: absolute;top: 470px;left:20px ;width: 440px;height: 50px;background: #BDCEFC;color: #fff;border-radius: 25px;cursor: pointer;border-style: none;">立即注册</button>

                </form>
            </div>
        </div>

    </div>
    <script src="/onlineBookStore/Pages/js/index.js" onload=""></script>
</body>
</html>