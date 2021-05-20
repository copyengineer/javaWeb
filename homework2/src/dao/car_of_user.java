/**
 * 
 */
package dao;

import java.sql.SQLException;

import bean.user;

/**
 * @author 22364
 *
 */
public class car_of_user extends basicDao<user>{

	public void saveMyCar(String jsessionid) {
		String sql = "update user set jsessionid = ? where userid = 1";
		
		try {
			update(sql, jsessionid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getsessionid() {
		String sql = "select * from user where userid=1";
		user getbean;
		try {
			getbean = getbean(sql);
			return getbean.getJsessionid(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
