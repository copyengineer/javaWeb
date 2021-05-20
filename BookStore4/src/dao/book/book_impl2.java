/**
 * 
 */
package dao.book;

import java.sql.SQLException;
import java.util.List;

import bean.book;
import dao.basicDao;

/**
 * @author 22364
 *
 */
public class book_impl2 extends basicDao<book> implements book_interface2{

	@Override
	public List<book> getallbook() {
		// TODO Auto-generated method stub
		String sql = "select * from book_info";
		try {
			List<book> list = getbeans(sql);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
}
