
/**
 * 
 */
package dao.book;

import java.util.List;

import bean.book;

/**
 * @author 22364
 *
 */
public interface book_interface2 {
	
	public List<book> getallbook();//获取所有书籍
	
	public List<book> getbook_bykeyword(String key);//按关键字查找图书
}
