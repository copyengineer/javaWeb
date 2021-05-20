package service;

import bean.users;

public interface userService {
	
	public int adduser(users user);
	public boolean getuser(users user);
	public users getuserByPhone(users user);
}
