package service.serviceImpl;

import bean.users;
import dao.user.userDao;
import dao.user.userDaoImpl;
import service.userService;


public class userServiceImpl implements userService{

	userDao userdao = new userDaoImpl();
	
	@Override
	public int adduser(users user) {
		// TODO Auto-generated method stub
		return userdao.addUser(user);//没有返回1则插入失败
	}

	@Override
	public boolean getuser(users user) {
		return userdao.selectOneUser(user);
	}

	@Override
	public users getuserByPhone(users user) {//根据手机号查找用户
		// TODO Auto-generated method stub
		return userdao.selectUserByPhone(user);
	}
	
	
	
}
