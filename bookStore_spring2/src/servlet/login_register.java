/*    */ package servlet;
/*    */ 
/*    */ import bean.user;
/*    */ import dao.userDaoImpl;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ public class login_register
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 18 */   private userDaoImpl userdao = new userDaoImpl();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 25 */     String type = request.getParameter("type");
/* 26 */     if (type.equals("login")) {
/* 27 */       String username_login = request.getParameter("username_login");
/* 28 */       String phoneNumber_login = request.getParameter("phoneNumber_login");
/* 29 */       String password_login = request.getParameter("password_login");
/* 30 */       String code1 = request.getParameter("cheackCode");
/* 31 */       String code2 = (String)request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
/* 32 */       if (!code1.equals(code2)) {
/* 33 */         request.setAttribute("login_sucess", "验证码输入错误");
/* 34 */         request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
/* 35 */         request.getRequestDispatcher("/pages/nologin_pages/loginAndRegister.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */       } else {
/* 37 */         user user = new user(username_login, password_login, phoneNumber_login);
/*    */         
/* 39 */         user cheackUser = this.userdao.cheackUser(user);
/*    */         
/* 41 */         if (cheackUser != null) {
/* 42 */           request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
/*    */           
/* 44 */           request.getRequestDispatcher("/pages/index.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */         } else {
/* 46 */           request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
/* 47 */           request.setAttribute("login_sucess", "用户名或密码有误，请重新输入");
/* 48 */           request.getRequestDispatcher("/pages/nologin_pages/loginAndRegister.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */         }
/*    */       
/*    */       }
/*    */     
/* 53 */     } else if (request.getParameter("action").equals("cheackUserName")) {
/* 54 */       String value = request.getParameter("value");
/* 55 */       if (this.userdao.getOneUser(value) != null) {
/* 56 */         response.getWriter().write("{\"isExist\":\"用户名已存在!!!\"}");
/* 57 */         System.out.println("用户名存在");
/*    */       } else {
/* 59 */         response.getWriter().write("{\"isExist\":\"欢迎注册\"}");
/*    */       } 
/*    */     } else {
/* 62 */       String username_register = request.getParameter("username_register");
/* 63 */       String phoneNumber_register = request.getParameter("phoneNumber_register");
/* 64 */       String password_register = request.getParameter("password_register");
/* 65 */       user user = new user(username_register, password_register, phoneNumber_register);
/*    */       
/* 67 */       int addUser = this.userdao.addUser(user);
/* 68 */       if (addUser == 1) {
/* 69 */         request.getRequestDispatcher("/pages/nologin_pages/loginAndRegister.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 75 */     doGet(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\servlet\login_register.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */