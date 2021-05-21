package dao;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.users;

public abstract class basicDao<T> {
	
	Class<T> t;//t����T��ʵ������
	
	public basicDao() {//�����������ʱĬ�ϵ��ø�����޲ι��죬�Ӷ�Ϊt��ֵ
		Class<? extends basicDao> clazz = this.getClass();
		Type type = clazz.getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		t = (Class) types[0];
	}

	public int update(String sql,Object... args) throws SQLException {
		Connection con = JDBCTools.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		if(args != null && args.length>0) {
			for(int i = 0;i<args.length;i++) {
				pst.setObject(i+1, args[i]);
			}
		}
		
		int len = pst.executeUpdate();
		return len;
	}
	
	//����һ���û�
	public T getbean(String sql,Object... args) throws SQLException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException {
		Connection con = JDBCTools.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		if(args != null && args.length>0) {
			for(int i = 0;i<args.length;i++) {
				pst.setObject(i+1, args[i]);
			}
		}
		ResultSet set = pst.executeQuery();
		
		T truetype = t.newInstance();
		
		ResultSetMetaData data = set.getMetaData();//Ԫ���ݶ���
		int coulmn = data.getColumnCount();//��ȡ�����������
		System.out.println(coulmn);
		if(set.next()) {
			//Ϊtruetype��������Ը�ֵ
			System.out.println("cunzai");
			//1����ȡ���Զ���
			for(int i=0;i<coulmn;i++) {//�м��о�˵���м�������
				Field field = t.getDeclaredField(data.getColumnName(i+1));//��ȡ��һ�е�������Ӧ��ĳ��ʵ�����ĳ�����Զ���
				field.setAccessible(true);//�������Կɷ���
				field.set(truetype, set.getObject(i+1));//��������ֵ
			}
		}else {
			truetype=null;
		}
		set.close();
		pst.close();
		return truetype;
	}
	
	//���Ҷ���û�
	public List<T> getbeans(String sql,Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Connection con = JDBCTools.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		if(args != null && args.length>0) {
			for(int i = 0;i<args.length;i++) {
				pst.setObject(i+1, args[i]);
			}
		}
		ResultSet set = pst.executeQuery();
			
		List<T> list = new ArrayList();
		ResultSetMetaData data = set.getMetaData();//Ԫ���ݶ���
		int coulmn = data.getColumnCount();//��ȡ�����������
			
		while(set.next()) {
			T truetype = t.newInstance();
			//Ϊtruetype��������Ը�ֵ
			for(int i=0;i<coulmn;i++) {//�м��о�˵���м�������
				Field field = t.getDeclaredField(data.getColumnName(i+1));//��ȡ��һ�е�������Ӧ��ĳ��ʵ�����ĳ�����Զ���
				field.setAccessible(true);//�������Կɷ���
				field.set(truetype, set.getObject(i+1));//��������ֵ
			}
			list.add(truetype);
		}
		return list;
	}
}
