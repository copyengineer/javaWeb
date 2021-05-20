/*    */ package service;
/*    */ 
/*    */ import bean.book;
/*    */ import dao.bookDao;
/*    */ import dao.bookDaoImpl;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class bookImpl
/*    */   implements bookService
/*    */ {
/* 13 */   private bookDao book_dao = (bookDao)new bookDaoImpl();
/*    */ 
/*    */   
/*    */   public List<book> service_dofilter(Map<String, String> map, int start) {
/* 17 */     String sql = "select * from book_info where";
/* 18 */     String[] keys = new String[6];
/*    */     
/* 20 */     if (map == null) {
/* 21 */       sql = "select * from book_info limit " + start + "," + '6';
/* 22 */     } else if (map.size() == 0 && start < 0) {
/* 23 */       sql = "select * from book_info";
/* 24 */     } else if (map.size() != 0) {
/* 25 */       Set<String> keySet = map.keySet();
/* 26 */       int i = 0;
/* 27 */       for (String key : keySet) {
/* 28 */         if (!key.equals("firstWord") && !((String)map.get(key)).equals("全部作品") && !((String)map.get(key)).equals("全部") && !key.equals("book_updatetime")) {
/* 29 */           keys[i] = key;
/* 30 */           i++;
/*    */         } 
/*    */       } 
/*    */       
/* 34 */       int len = 0;
/* 35 */       for (int k = 0; k < keys.length; k++) {
/* 36 */         if (keys[k] != null) {
/* 37 */           len++;
/*    */         }
/*    */       } 
/*    */       
/* 41 */       for (int j = 0; j < len; j++) {
/*    */         
/* 43 */         if (j != len - 1) {
/* 44 */           sql = String.valueOf(sql) + " " + keys[j] + "=" + '\'' + (String)map.get(keys[j]) + '\'' + " and";
/*    */         }
/* 46 */         else if (start < 0) {
/* 47 */           sql = String.valueOf(sql) + " " + keys[j] + "=" + '\'' + (String)map.get(keys[j]) + '\'';
/*    */         } else {
/* 49 */           sql = String.valueOf(sql) + " " + keys[j] + "=" + '\'' + (String)map.get(keys[j]) + '\'' + " limit " + start + "," + '6';
/*    */         } 
/*    */       } 
/*    */     } else {
/*    */       
/* 54 */       sql = "select * from book_info limit " + start + "," + '6';
/*    */     } 
/* 56 */     return this.book_dao.dao_dofilter(sql);
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\service\bookImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */