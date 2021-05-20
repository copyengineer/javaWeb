package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCTools {
	
	static DataSource source;
	static ThreadLocal<Connection> tL;
	static {
		Properties properties = new Properties();
		try {
			properties.load(JDBCTools.class.getClassLoader().getResourceAsStream("druid.properties"));
			source = DruidDataSourceFactory.createDataSource(properties);
			tL = new ThreadLocal<Connection>();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection() throws SQLException {
		Connection con = tL.get();
		if(con == null) {
			con = source.getConnection();
			tL.set(con);
			
		}
		System.out.println(con);
		return con;
	}
}
