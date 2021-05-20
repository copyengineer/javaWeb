package dao.user;

import bean.users;

public interface userDao {
	public int addUser(users user);//添加用户
	public int delete(users user);//删除用户
	public boolean selectOneUser(users user);//查找用户,若存在该用户，则返回用户对象，不存在则返回null
	public users selectUserByPhone(users user);//根据手机号查找用户是否存在
}
