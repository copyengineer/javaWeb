/*    */ package dao;
/*    */ 
/*    */ import bean.user;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class userDaoImpl
/*    */   extends basicDao<user>
/*    */ {
/*    */   public user getOneUser(String userName) {
/* 12 */     String sql = "select * from user_info where userName = ?";
/*    */     try {
/* 14 */       user user = getbean(sql, new Object[] { userName });
/* 15 */       return user;
/* 16 */     } catch (Exception e) {
/* 17 */       System.out.println("按用户名查找用户出错了!");
/* 18 */       e.printStackTrace();
/* 19 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public int addUser(user user1) {
/* 24 */     String sql = "insert into user_info values(?,?,?)";
/*    */     try {
/* 26 */       int update = update(sql, new Object[] { user1.getUserName(), user1.getPassWord(), user1.getPhoneNumber() });
/* 27 */       return update;
/* 28 */     } catch (Exception e) {
/* 29 */       System.out.println("添加用户出错了!");
/* 30 */       e.printStackTrace();
/* 31 */       return 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public user cheackUser(user user1) {
/* 36 */     String sql = "select * from user_info where userName=? and passWord=? and phoneNumber=?";
/*    */     try {
/* 38 */       user bean = getbean(sql, new Object[] { user1.getUserName(), user1.getPassWord(), user1.getPhoneNumber() });
/* 39 */       return bean;
/* 40 */     } catch (Exception e) {
/* 41 */       System.out.println("验证用户出错了!");
/* 42 */       e.printStackTrace();
/* 43 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\22364\Desktop\bookStore_spring2\WEB-INF\classes\!\da\\userDaoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */