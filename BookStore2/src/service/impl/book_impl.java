/**
 * 
 */
package service.impl;

import java.util.List;

import bean.book;
import dao.book.book_impl2;
import dao.book.book_interface2;
import service.book_interface;

/**
 * @author 22364
 *
 */
public class book_impl implements book_interface{

	book_interface2 bim = new book_impl2();
	
	@Override
	public List<book> getAllBook() {
		// TODO Auto-generated method stub
		return bim.getallbook();
	}
	
}
