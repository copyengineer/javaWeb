package dao.user;

import java.sql.SQLException;

import bean.users;
import dao.basicDao;

public class userDaoImpl extends basicDao<users> implements userDao{

	
	public userDaoImpl() {
		super();
	}

	@Override
	public int addUser(users user) {
		String sql = "insert into users values(?,?,?)";
		try {
			int len = update(sql, user.getUsername(),user.getPhone(),user.getPassword());
			return len;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	@Override
	public int delete(users user) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 查找数据库中是否存在user用户
	 */
	@Override
	public boolean selectOneUser(users user) {
		String sql = "select * from users where phone=? and username=? and password=?";
		
		try {
			users u = getbean(sql,user.getPhone(),user.getUsername(),user.getPassword());
			if(u!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
		
		return false;
	}

	@Override
	public users selectUserByPhone(users user) {
		String sql = "select * from users where phone=?";
		try {
			return getbean(sql, user.getPhone());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

}
