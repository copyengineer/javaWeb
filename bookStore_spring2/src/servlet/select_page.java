/*    */ package servlet;
/*    */ 
/*    */ import bean.book;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ public class select_page
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 19 */   private bookFilter bookFilter = new bookFilter();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*    */     int pageSize, nowPage;
/* 26 */     String page = request.getParameter("page");
/*    */ 
/*    */     
/* 29 */     if (request.getSession().getAttribute("pageSize") != null) {
/* 30 */       pageSize = ((Integer)request.getSession().getAttribute("pageSize")).intValue();
/* 31 */       nowPage = ((Integer)request.getSession().getAttribute("nowPage")).intValue();
/*    */     } else {
/* 33 */       pageSize = 6;
/* 34 */       nowPage = 1;
/*    */     } 
/* 36 */     System.out.println(nowPage);
/* 37 */     List<book> books = null;
/*    */     
/* 39 */     if (page.equals("lastPage")) {
/* 40 */       if (nowPage == 1) {
/* 41 */         books = this.bookFilter.dofilter((Map<String, String>)request.getSession().getAttribute("filterMap"), 0);
/*    */ 
/*    */       
/*    */       }
/*    */       else {
/*    */ 
/*    */         
/* 48 */         books = this.bookFilter.dofilter((Map<String, String>)request.getSession().getAttribute("filterMap"), (nowPage - 2) * 6);
/* 49 */         nowPage--;
/*    */       } 
/*    */     }
/* 52 */     if (page.equals("nextPage")) {
/* 53 */       if (nowPage == pageSize) {
/* 54 */         books = this.bookFilter.dofilter((Map<String, String>)request.getSession().getAttribute("filterMap"), (nowPage - 1) * 6);
/*    */       } else {
/* 56 */         books = this.bookFilter.dofilter((Map<String, String>)request.getSession().getAttribute("filterMap"), nowPage * 6);
/* 57 */         nowPage++;
/* 58 */         System.out.println(nowPage);
/*    */       } 
/*    */     }
/*    */     
/* 62 */     if (page.equals("firstPage")) {
/* 63 */       books = this.bookFilter.dofilter((Map<String, String>)request.getSession().getAttribute("filterMap"), 0);
/* 64 */       nowPage = 1;
/*    */     } 
/* 66 */     if (page.equals("endPage")) {
/* 67 */       books = this.bookFilter.dofilter((Map<String, String>)request.getSession().getAttribute("filterMap"), (pageSize - 1) * 6);
/* 68 */       nowPage = pageSize;
/*    */     } 
/* 70 */     if (page.equals("customerPage")) {
/* 71 */       int pageChoice = Integer.parseInt(request.getParameter("pageChoice"));
/* 72 */       books = this.bookFilter.dofilter((Map<String, String>)request.getSession().getAttribute("filterMap"), (pageChoice - 1) * 6);
/* 73 */       nowPage = pageChoice;
/*    */     } 
/*    */     
/* 76 */     request.setAttribute("books", books);
/* 77 */     request.getSession().setAttribute("nowPage", Integer.valueOf(nowPage));
/* 78 */     request.getRequestDispatcher("/pages/nologin_pages/index.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 82 */     doGet(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\servlet\select_page.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */