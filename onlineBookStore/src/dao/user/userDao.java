package dao.user;

import bean.users;

public interface userDao {
	public int addUser(users user);//����û�
	public int delete(users user);//ɾ���û�
	public boolean selectOneUser(users user);//�����û�,�����ڸ��û����򷵻��û����󣬲������򷵻�null
	public users selectUserByPhone(users user);//�����ֻ��Ų����û��Ƿ����
}
