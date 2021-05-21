package servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rnkrsoft.bopomofo4j.Bopomofo4j;

import bean.book;

/**
 * Servlet implementation class book_filter
 */
public class book_filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;  
    private HttpServletResponse response;
    private List<book> allbook = new ArrayList<book>();
    private Map<String, String> filter_list = new HashMap<String, String>();   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.request = request;
		this.response = response;
		//filter_list.clear();���ѡ���������ٰ����ˣ���ѡ�񣬻�������⣬��Ϊ��ѡ���ʱ��filter_list��Ȼ�����Ű�����֮ǰ�����ݣ����ﲻ����clear������ȱ�������
		allbook = (List<book>) request.getSession().getAttribute("allBookInfo2");
		
		String method = request.getParameter("name");
		String type = request.getParameter("value");
		filter_list.put(method, type);
		
		Set<String> keySet = filter_list.keySet();
		Collection<String> values = filter_list.values();
		
		for (String key : keySet) {
			Method mtd;
			try {
				mtd = book_filter.class.getDeclaredMethod(key,String.class);
				mtd.invoke(this, filter_list.get(key));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		System.out.println(filter_list);
		request.getSession().removeAttribute("allBookInfo");
		request.getSession().setAttribute("allBookInfo", allbook);
		request.getSession().setAttribute("live", filter_list);
		request.getRequestDispatcher("/Pages/pages/index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void getBookByType(String type) throws ServletException, IOException {
	
		List<book> attribute2 = new ArrayList<book>();
		if(!type.equals("ȫ����Ʒ")) {
			for (book book : allbook) {
				if(book.getBook_type().contains(type)) {
					attribute2.add(book);
				}
			}
			allbook = attribute2;
		}
	}
	
	protected void getBookByFirstWord(String word) throws ServletException, IOException {
		if(word.equals("ȫ��")) {
			return;
		}
		List<book> books = new ArrayList<book>();
		Bopomofo4j.local();
		
		for (book book : allbook) {
			String book_name = book.getBook_name();
			String pinyin = Bopomofo4j.pinyin(book_name, 2, false, false, "");
			char fistword = pinyin.charAt(0);
			char trueword = word.charAt(0);
			
			if(fistword==trueword) {//�Ȿ�����������ĸ�ʹ�����������ĸһ��
				books.add(book);
			}
		}
		allbook = books;
	}
	
	
}
