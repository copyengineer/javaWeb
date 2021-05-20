
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;


public class JDBCTools {
	
	
	//获取连接
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties pro = new Properties();
		pro.load(JDBCTools.class.getClassLoader().getResourceAsStream("druid.properties"));
		String url = pro.getProperty("url");
		String user = pro.getProperty("usernamec");
		String password = pro.getProperty("password");
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
