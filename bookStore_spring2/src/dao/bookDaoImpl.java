/*    */ package dao;
/*    */ 
/*    */ import bean.book;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class bookDaoImpl
/*    */   extends basicDao<book>
/*    */   implements bookDao
/*    */ {
/*    */   public List<book> dao_dofilter(String sql) {
/*    */     try {
			System.out.println(sql);
/* 14 */       return getbeans(sql, new Object[0]);
/* 15 */     } catch (Exception e) {
/* 16 */       e.printStackTrace();
/* 17 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int getStartSize() {
/* 23 */     String sql = "select * from book_info";
/*    */     try {
/* 25 */       List<book> books = getbeans(sql, new Object[0]);
/* 26 */       int startSize = (books.size() % 6 == 0) ? (books.size() / 6) : (books.size() / 6 + 1);
/* 27 */       System.out.println(startSize);
/* 28 */       return startSize;
/* 29 */     } catch (Exception e) {
/* 30 */       e.printStackTrace();
/* 31 */       return -1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\dao\bookDaoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */