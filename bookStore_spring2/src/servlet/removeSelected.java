/*    */ package servlet;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class removeSelected
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 18 */     String key = request.getParameter("value");
/* 19 */     Map<String, String> filterMap = (Map<String, String>)request.getSession().getAttribute("filterMap");
/* 20 */     filterMap.remove(key);
/* 21 */     request.getRequestDispatcher("/bookFilter").forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 25 */     doGet(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\servlet\removeSelected.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */