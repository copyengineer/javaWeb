import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 
 */

/**
 * @author 22364
 *
 */
public class test {
	public static void main(String[] args) {
		
		
			try {
				Connection con = JDBCTools.getConnection();
				System.out.println(con.hashCode());
				con.close();
				Connection con2 = JDBCTools.getConnection();
				System.out.println(con2.hashCode());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
//		Properties pro = new Properties();
//		try {
//			pro.load(test.class.getClassLoader().getResourceAsStream("druid.properties"));
//			DataSource ds = DruidDataSourceFactory.createDataSource(pro);
//			Connection con = ds.getConnection();
//			System.out.println(con);
//			con.close();
//			con.createStatement();
		
//			for(int i=0;i<10;i++) {
//				
//				Connection con2 = ds.getConnection();
//				System.out.println(i+""+":"+con2);
//				
//			}
			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
