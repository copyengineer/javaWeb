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
	
	public List<book> getAllBook();//�õ�����ͼ��
	
	public List<book> getbook_bykeyword(String key);//���ؼ��ֲ���ͼ��
}
