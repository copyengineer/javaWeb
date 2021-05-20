var a = document.getElementById("f1");//登陆按钮
var b = document.getElementById("f2");//注册按钮
var a1 = document.getElementsByClassName("tab1");//登陆界面
var b1 = document.getElementsByClassName("tab2");//注册界面

var c1 = document.getElementById("c1");
var c2 = document.getElementById("c2");
//输入框获取焦点后清空默认提示文本





//点击登陆时触发
a.onclick = function(){
    a.style.background = "#E0ECF8";
    a1[0].style.background = "#E0ECF8";
    a1[0].style.display = "block";
    b1[0].style.display = "none";
    b.style.background = "none";
	c2.innerHTML="欢迎注册";
}
//点击注册时触发
b.onclick = function(){
    b.style.background = "#E0ECF8";
    a.style.background = "none";
    a1[0].style.display = "none";
    b1[0].style.display = "block";
    b1[0].style.background = "#E0ECF8";
    b1[0].style.opacity="1.0";
	c1.innerHTML="欢迎登陆";
}