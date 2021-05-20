<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>世纪佳缘注册页</title>
    <base href="http://localhost:8080/myProject/aa/">
    <link rel="stylesheet" href="sjjy.css">
</head>
<body>
	<%
			out.print(session.getAttribute("j"));
		%>
    <div id="content">
        <div class="left">
            <img src="sjjy.img/jy_common_1578537635.jpg" alt="">
            <div class="bravelove"></div>
            <div class="ad"></div>
        </div>
        <div class="right">
            <h1 class="r-h1" style="color:#f3316b;">青春不常在，抓紧谈恋爱</h1>
            <div class="r-h1-title">花点时间填写真实信息，我们会让结果更和你的心意。</div>
            <span class="s1"></span>
            <span class="s2"></span>
            <dl class="sex">
                <dt>我是</dt>
                <dd class="sexchoice">
                    <input id="nan" class="ir" value="m" type="radio" name="sex">
                    <label class="nan" for="nan">男</label>
                    <input id="nv" class="ir" value="f" type="radio" name="sex">
                    <label class="nv" for="nv">女</label>
                </dd>
                <dd class="change">
                    <p class="def">* 注册后修改需联系客服</p>
                </dd>
            </dl>
            <dl class="birth">
                <dt>生日</dt>
                <dd class="fl" id="sc">
                    <div class="year fl" id="same" style="position: relative;" onclick="cc()" >
                        <input name="year" class="te" value="请选择" type="text" readonly="readonly" onblur="dd()" style="cursor: pointer;">
                        <span class="d-t">年</span>
                        <div id="age" style="display: none;">
                            <span>90后:</span>
                            <a href="#">1990</a>
                            <a href="#">1991</a>
                            <a href="#">1992</a>
                            <a href="#">1993</a>
                            <a href="#">1994</a>
                            <a href="#">1995</a>
                            <a href="#">1996</a>
                            <a href="#">1997</a>
                            <a href="#">1998</a>
                            <a href="#">1999</a>
                            <span>80后:</span>
                            <a href="#">1980</a>
                            <a href="#">1981</a>
                            <a href="#">1982</a>
                            <a href="#">1983</a>
                            <a href="#">1984</a>
                            <a href="#">1985</a>
                            <a href="#">1986</a>
                            <a href="#">1987</a>
                            <a href="#">1988</a>
                            <a href="#">1989</a>
                            <span>70后:</span>
                            <a href="#">1970</a>
                            <a href="#">1971</a>
                            <a href="#">1972</a>
                            <a href="#">1973</a>
                            <a href="#">1974</a>
                            <a href="#">1975</a>
                            <a href="#">1976</a>
                            <a href="#">1977</a>
                            <a href="#">1978</a>
                            <a href="#">1979</a>
                            <span>60后:</span>
                            <a href="#">1960</a>
                            <a href="#">1961</a>
                            <a href="#">1962</a>
                            <a href="#">1963</a>
                            <a href="#">1964</a>
                            <a href="#">1965</a>
                            <a href="#">1966</a>
                            <a href="#">1967</a>
                            <a href="#">1968</a>
                            <a href="#">1969</a>
                            <span>50后:</span>
                            <a href="#">1950</a>
                            <a href="#">1951</a>
                            <a href="#">1952</a>
                            <a href="#">1953</a>
                            <a href="#">1954</a>
                            <a href="#">1955</a>
                            <a href="#">1956</a>
                            <a href="#">1957</a>
                            <a href="#">1958</a>
                            <a href="#">1959</a>
                            <span>40后:</span>
                            <a href="#">1940</a>
                            <a href="#">1941</a>
                            <a href="#">1942</a>
                            <a href="#">1943</a>
                            <a href="#">1944</a>
                            <a href="#">1945</a>
                            <a href="#">1946</a>
                            <a href="#">1947</a>
                            <a href="#">1948</a>
                            <a href="#">1949</a>
                            <span>30后:</span>
                            <a href="#">1930</a>
                            <a href="#">1931</a>
                            <a href="#">1932</a>
                            <a href="#">1933</a>
                            <a href="#">1934</a>
                            <a href="#">1935</a>
                            <a href="#">1936</a>
                            <a href="#">1937</a>
                            <a href="#">1938</a>
                            <a href="#">1939</a>
                        </div>
                    </div>
                    <div class="month fl" id="same">
                        <input id="month" name="month" class="te" type="text" value="请选择" readonly="readonly">
                        <span class="d-t">月</span>
                    </div>
                    <div class="day fl" id="same">
                        <input id="day" name="day" class="te" type="text" value="请选择" readonly="readonly">
                        <span class="d-t">日</span>
                    </div>
                </dd>
                <dd class="change fl">
                    <p class="def">* 注册后修改需联系客服</p>
                </dd>
            </dl>
            <dl class="live">
                <dt>常住地</dt>
                <dd id="sc">
                    <input id="address" class="te w_input" type="text" value="请选择" readonly="readonly" style="width: 278px;height: 32px;border: none; background: url(./sjjy.img/reg_bg.jpg) no-repeat 0 -420px;text-indent:8.5px ;outline: none;">
                </dd>
            </dl>
            <dl class="c">
                <dt>婚姻状况</dt>
                <dd id="sc">
                    <input type="radio" name="marrige">
                    <label class="marr" for="m-ly">未婚</label>
                    <input type="radio" name="marrige">
                    <label class="marr" for="m-so">丧偶</label>
                    <input type="radio" name="marrige">
                    <label class="marr" for="m-wh">离异</label>
                </dd>
            </dl>
            <dl class="hight">
                <dt>身高</dt>
                <dd id="sc">
                    <input id="address" class="te w_input" type="text" value="请选择" readonly="readonly" style="width: 278px;height: 32px;border: none; background: url(./sjjy.img/reg_bg.jpg) no-repeat 0 -420px;text-indent:8.5px ;outline: none;">
                </dd>
            </dl>
            <dl class="study">
                <dt>学历</dt>
                <dd id="sc">
                    <input id="address" class="te w_input" type="text" value="请选择" readonly="readonly" style="width: 278px;height: 32px;border: none; background: url(./sjjy.img/reg_bg.jpg) no-repeat 0 -420px;text-indent:8.5px ;outline: none;">
                </dd>
            </dl>
            <dl class="money">
                <dt>月薪</dt>
                <dd id="sc">
                    <input id="address" class="te w_input" type="text" value="请选择" readonly="readonly" style="width: 278px;height: 32px;border: none; background: url(./sjjy.img/reg_bg.jpg) no-repeat 0 -420px;text-indent:8.5px ;outline: none;">
                </dd>
            </dl>
            <div class="line"></div>
            <div style="padding-top:10px;padding-left:100px;"><a href="https://www.jiayuan.com/register/user_read.html" target="_blank" style="color:#939393;text-decoration:underline;font-size: 12px;">全国人大常委会关于加强网络信息保护的决定</a></div>
            <dl class="phone">
                <dt>手机号</dt>
                <dd>
                   <div id="ear">
                        <span id="china">中国+86</span>
                        <input id="phonenumber" class="te w_input" type="text" value="请选择" readonly="readonly" style="border: none;text-indent:8.5px ;outline: none;">
                        <span id="aa"></span>
                   </div>
                </dd>
            </dl>
            <dl class="yz">
                <dt>验证码</dt>
                <dd id="sc">
                    <input id="address" class="te w_input" type="text" value="请选择" readonly="readonly" style="width: 169px;height: 32px;border: none; background: url(./sjjy.img/reg_bg.jpg) no-repeat 0 -454px;text-indent:8.5px ;outline: none;">
                </dd>
            </dl>
            <dl class="create">
                <dt>创建密码</dt>
                <dd id="sc">
                    <input id="address" class="te w_input" type="text" value="请选择" readonly="readonly" style="width: 278px;height: 32px;border: none; background: url(./sjjy.img/reg_bg.jpg) no-repeat 0 -420px;text-indent:8.5px ;outline: none;">
                </dd>
            </dl>
            <dl class="create">
                <dt>昵称</dt>
                <dd id="sc">
                    <input id="address" class="te w_input" type="text" value="请选择" readonly="readonly" style="width: 278px;height: 32px;border: none; background: url(./sjjy.img/reg_bg.jpg) no-repeat 0 -420px;text-indent:8.5px ;outline: none;">
                </dd>
                <a href="#" id="c">换一个</a>
            </dl>
            <dl class="myself" style="height: 181.6px;">
                <dt>自我介绍</dt>
                <dd class="zw">
                    <ul style="height: 29px;">
                        <li class="fl">
                            <a href="###">贴标签</a>
                        </li>
                        <li class="fl">
                            <a href="###">自己写</a>
                        </li>
                        <li class="fl">
                            <a href="###">帮你写</a>
                        </li>
                    </ul>
                    <div class="b1 bf">
                        <a href="#" class="t1">有责任心</a>
                        <a href="#" class="t2">诚信</a>
                        <a href="#" style="width: 56px;background-color: #b0915d;">爱挑战</a>
                        <a href="#" class="t1">完美主义</a>
                        <a href="#" class="t2">靠谱</a>
                        <a href="#" class="t3">正直</a>
                        <a href="#" class="t7">执着</a>
                        <a href="#" class="t2">憨厚</a>
                        <a href="#" class="t3">美食</a>
                        <a href="#" class="t4">摄影</a>
                        <a href="#" class="t2">听歌</a>
                        <a href="#" class="t3">网游</a>
                        <a href="#" class="t4">旅行</a>
                        <a href="#" class="t2">运动</a>
                        <a href="#" class="t7">帅</a>
                        <a href="#" class="t1">有男人味</a>
                        <a href="#" class="t2">高大</a>
                        <a href="#" class="t3">健康</a>
                        <a href="#" class="t1">四世同堂</a>
                        <a href="#" class="t5">单亲家庭</a>
                        <a href="#" class="t6">高质家庭</a>
                        <a href="#" class="t1">三口之家</a>
                        <a href="#" class="t5">千杯不醉</a>
                        <a href="#" class="t6">狂吃不胖</a>
                        <a href="#" style="background-color: #ce6e7b;width: 56px;">晒不黑</a>
                        <a href="#" class="t5">力大无穷</a>
                    </div>
                    <div class="b2 bf" style="display: none;"></div>
                    <div class="b3 bf" style="display: none;"></div>
                </dd>
            </dl>
            <form action="endServlet" method="get">
                <div class="finish">
                    <div>
                        <button type="submit" style="cursor: pointer;"></button>
                        <input style="width:50px;height="20px" name="password">
                    </div>
                </div>
            </form>
            <div class="last">
                <p class="p1">
                    <input type="checkbox" name="policy" style="width: 12.8px;height: 12.8px;">
                    <label for="policy">我同意<a href="#">注册条款</a>和<a href="#">会员加入标准</a></label>
                </p>
                <p class="p2">我承诺年满18岁、单身、抱着积极的态度，真诚交友</p>
            </div>
        </div>
        <div class="sidenave" style="height: 131.8px;">
            <p class="d1"><a href="#">会员登录</a></p>
            <p class="d2"><a href="#">其他账号登录</a></p>
            <ul class="d3" style="height: 25px;">
                <li><a href="#" class="pt1"></a></li>
                <li><a href="#" class="pt2"></a></li>
                <li><a href="#" class="pt3"></a></li>
                <li><a href="#" class="pt4"></a></li>
                <li><a href="#" class="pt5"></a></li>
                <li><a href="#" class="pt6"></a></li>
            </ul>
            <a href="#" class="pt7" onclick="down()"></a>
        </div>
    </div>
    <script src="./sjjy.js"></script>
</body>
</html>