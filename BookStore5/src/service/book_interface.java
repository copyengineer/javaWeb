/**
 * 
 */
package service;

import java.util.List;

import bean.book;

/**
 * @author 22364
 *
 */
public interface book_interface {
	
	public List<book> getAllBook();//得到所有图书
	
	public List<book> getbook_bykeyword(String key);//按关键字查找图书
}
