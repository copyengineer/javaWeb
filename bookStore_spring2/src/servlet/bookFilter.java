/*    */ package servlet;
/*    */ 
/*    */ import bean.book;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import service.bookImpl;
/*    */ import service.bookService;
/*    */ 
/*    */ public class bookFilter extends HttpServlet {
/* 19 */   bookService book_service = (bookService)new bookImpl();
/*    */ 
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 26 */     String name = request.getParameter("name");
/* 27 */     String value = request.getParameter("value");
/*    */     
/* 29 */     Map<String, String> filterMap = null;
/*    */     
/* 31 */     if (request.getSession().getAttribute("filterMap") == null) {
/* 32 */       filterMap = new HashMap<>();
/* 33 */       filterMap.put(name, value);
/* 34 */       request.getSession().setAttribute("filterMap", filterMap);
/*    */     } else {
/* 36 */       filterMap = (Map<String, String>)request.getSession().getAttribute("filterMap");
/* 37 */       if (name != null && value != null) {
/* 38 */         filterMap.put(name, value);
/*    */       }
/*    */     } 
/*    */     
/* 42 */     List<book> books = dofilter(filterMap, 0);
/* 43 */     System.out.println(filterMap);
/* 44 */     int size = dofilter(filterMap, -1).size();
/* 45 */     int pageSize = (size % 6 == 0) ? (size / 6) : (size / 6 + 1);
/* 46 */     Map<String, String> selected = select_item(filterMap);
/*    */     
/* 48 */     request.setAttribute("books", books);
/* 49 */     request.getSession().setAttribute("selected", selected);
/* 50 */     request.getSession().setAttribute("pageSize", Integer.valueOf(pageSize));
/* 51 */     request.getSession().setAttribute("nowPage", Integer.valueOf(1));
/* 52 */     System.out.println(pageSize);
/* 53 */     request.getRequestDispatcher("/pages/nologin_pages/index.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, String> select_item(Map<String, String> filterMap) {
/* 61 */     Set<String> keySet = filterMap.keySet();
/* 62 */     Map<String, String> filterMap2 = new HashMap<>();
/* 63 */     for (String key : keySet) {
/* 64 */       if (!((String)filterMap.get(key)).equals("全部") && !((String)filterMap.get(key)).equals("全部作品")) {
/* 65 */         filterMap2.put(key, filterMap.get(key));
/*    */       }
/*    */     } 
/* 68 */     return filterMap2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<book> dofilter(Map<String, String> filterMap, int start) {
/* 75 */     return this.book_service.service_dofilter(filterMap, start);
/*    */   }
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 79 */     doGet(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\servlet\bookFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */