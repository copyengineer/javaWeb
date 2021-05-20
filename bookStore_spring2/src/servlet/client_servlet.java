/*    */ package servlet;
/*    */ 
/*    */ import bean.book;
/*    */ import dao.bookDao;
/*    */ import dao.bookDaoImpl;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class client_servlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   private bookFilter bookFilter = new bookFilter();
/* 23 */   private bookDao bookDao = (bookDao)new bookDaoImpl();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 30 */     List<book> books = this.bookFilter.dofilter(null, 0);
/* 31 */     request.setAttribute("books", books);
/*    */     
/* 33 */     int startSize = this.bookDao.getStartSize();
/* 34 */     request.getSession().setAttribute("pageSize", Integer.valueOf(startSize));
/* 35 */     request.getSession().setAttribute("nowPage", Integer.valueOf(1));
/* 36 */     request.getSession().setAttribute("selected", new HashMap<>());
/* 37 */     request.getRequestDispatcher("/pages/nologin_pages/index.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 41 */     doGet(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\servlet\client_servlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */