
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
	
	public List<book> getallbook();//��ȡ�����鼮
	
	public List<book> getbook_bykeyword(String key);//���ؼ��ֲ���ͼ��
}
