var ua=document.getElementsByClassName("d3")[0];
var u=document.getElementsByClassName("sidenave")[0];
var uc=document.getElementsByClassName("pt7")[0];
var c=1;
function down(){
   if(c%2!=0)
   {
      ua.style.height="60px";
      u.style.height="166.8px";
      uc.style.background="url(./sjjy.img/slide-up.png) no-repeat center 4px";
      c++;
   }
   else{
      ua.style.height="25px";
      u.style.height="131.8px";
      uc.style.background="url(./sjjy.img/slide-down.png) no-repeat center 4px";
      c++;
   }
}
var age=document.getElementById("age");
function cc(){
   age.style.display="block";
}
function dd(){
   age.style.display="none";
}