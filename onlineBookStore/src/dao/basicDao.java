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
	
	Class<T> t;//t代表T的实际类型
	
	public basicDao() {//创建子类对象时默认调用父类的无参构造，从而为t赋值
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
	
	//查找一个用户
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
		
		ResultSetMetaData data = set.getMetaData();//元数据对象
		int coulmn = data.getColumnCount();//获取结果集的列数
		System.out.println(coulmn);
		if(set.next()) {
			//为truetype对象的属性赋值
			System.out.println("cunzai");
			//1、获取属性对象
			for(int i=0;i<coulmn;i++) {//有几列就说明有几个属性
				Field field = t.getDeclaredField(data.getColumnName(i+1));//获取第一列的列名对应的某个实体类的某个属性对象
				field.setAccessible(true);//设置属性可访问
				field.set(truetype, set.getObject(i+1));//设置属性值
			}
		}else {
			truetype=null;
		}
		set.close();
		pst.close();
		return truetype;
	}
	
	//查找多个用户
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
		ResultSetMetaData data = set.getMetaData();//元数据对象
		int coulmn = data.getColumnCount();//获取结果集的列数
			
		while(set.next()) {
			T truetype = t.newInstance();
			//为truetype对象的属性赋值
			for(int i=0;i<coulmn;i++) {//有几列就说明有几个属性
				Field field = t.getDeclaredField(data.getColumnName(i+1));//获取第一列的列名对应的某个实体类的某个属性对象
				field.setAccessible(true);//设置属性可访问
				field.set(truetype, set.getObject(i+1));//设置属性值
			}
			list.add(truetype);
		}
		return list;
	}
}
