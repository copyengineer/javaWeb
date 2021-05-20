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

import bean.Page;
import bean.book;
import service.book_interface;
import service.impl.book_impl;

/**
 * Servlet implementation class book_filter
 */
public class book_filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;  
    private HttpServletResponse response;
    private List<book> allbook = new ArrayList<book>();
    private Map<String, String> filter_list = new HashMap<String, String>();   
	book_interface service = new book_impl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.request = request;
		this.response = response;
		//filter_list.clear();如果选了条件，再按回退，再选择，会出现问题，因为再选择的时候，filter_list仍然保存着按回退之前的数据，这里不能用clear解决，先保留问题
		allbook = (List<book>) request.getSession().getAttribute("allBookInfo2");
		
		String method = request.getParameter("name");
		String type = request.getParameter("value");
		if(!method.equals("getbook_bykeyword") && !method.equals("getbook_bypage")) {
			dofilter(method,type);
			HashMap< String,Integer> map = new HashMap<String, Integer>();
			map.put("inline-block", allbook.size()%2==0?allbook.size()/2:allbook.size()/2+1);
			Page p = ((Page)(request.getSession().getAttribute("page")));
			p.setPagechoice8(map);
			request.setAttribute("page", p);
		}else if(method.equals("getbook_bykeyword")){
			try {
				getbook_bykeyword(type);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
			dofilter(null,null);
			getbook_bypage(type);
		}
		
		System.out.println(filter_list);
		
		request.setAttribute("allBookInfo", allbook);
		request.setAttribute("live", filter_list);
		request.getRequestDispatcher("/Pages/pages/index.jsp").forward(request, response);
		
		
	}

	/**
	 * @param type
	 *根据页码显示图书
	 */
	private void getbook_bypage(String type) {
		int page_num = Integer.parseInt(type);
		int num = allbook.size()%2==0?allbook.size()/2:allbook.size()/2+1;
		List<book> list;
		if(page_num == num) {
			list = new ArrayList<book>();
			list.addAll(allbook.subList((page_num-1)*2,(page_num-1)*2+1));
		}else {
			list = new ArrayList<book>();
			list.addAll(allbook.subList((page_num-1)*2,(page_num-1)*2+2));
		}
		
		
		allbook = list;
		if(num-page_num==3) {
			Map<String, Integer> pagechoice1 = new HashMap<String, Integer>();
			pagechoice1.put("inline-block", 1);
			
			Map<String, Integer> pagechoice2 = new HashMap<String, Integer>();
			pagechoice2.put("inline-block", page_num-2);
			
			Map<String, Integer> pagechoice3 = new HashMap<String, Integer>();
			pagechoice3.put("inline-block", page_num-1);
			
			Map<String, Integer> pagechoice4 = new HashMap<String, Integer>();
			pagechoice4.put("inline-block", page_num);
			
			Map<String, Integer> pagechoice5 = new HashMap<String, Integer>();
			pagechoice5.put("inline-block", page_num+1);
			
			Map<String, Integer> pagechoice6 = new HashMap<String, Integer>();
			pagechoice6.put("inline-block", page_num+2);
			
			Map<String, Integer> pagechoice7 = new HashMap<String, Integer>();
			pagechoice7.put("none", 7);
			
			Map<String, Integer> pagechoice8 = new HashMap<String, Integer>();
			pagechoice8.put("inline-block", num);
			request.setAttribute("activepage", page_num);
			request.setAttribute("page", new Page("inline-block", pagechoice1, "inline-block", pagechoice2, pagechoice3, pagechoice4, pagechoice5, pagechoice6, "none", pagechoice7, "none", pagechoice8));
		}else if(num-page_num<3) {
			Map<String, Integer> pagechoice1 = new HashMap<String, Integer>();
			pagechoice1.put("inline-block", 1);
			
			Map<String, Integer> pagechoice2 = new HashMap<String, Integer>();
			pagechoice2.put("inline-block", num-5);
			
			Map<String, Integer> pagechoice3 = new HashMap<String, Integer>();
			pagechoice3.put("inline-block", num-4);
			
			Map<String, Integer> pagechoice4 = new HashMap<String, Integer>();
			pagechoice4.put("inline-block", num-3);
			
			Map<String, Integer> pagechoice5 = new HashMap<String, Integer>();
			pagechoice5.put("inline-block", num-2);
			
			Map<String, Integer> pagechoice6 = new HashMap<String, Integer>();
			pagechoice6.put("inline-block", num-1);
			
			Map<String, Integer> pagechoice7 = new HashMap<String, Integer>();
			pagechoice7.put("none", 7);
			
			Map<String, Integer> pagechoice8 = new HashMap<String, Integer>();
			pagechoice8.put("inline-block", num);
			request.setAttribute("activepage", page_num);
			request.setAttribute("page", new Page("inline-block", pagechoice1, "inline-block", pagechoice2, pagechoice3, pagechoice4, pagechoice5, pagechoice6, "none", pagechoice7, "none", pagechoice8));
		}else if(page_num<5 && page_num>1) {
			Map<String, Integer> pagechoice1 = new HashMap<String, Integer>();
			pagechoice1.put("inline-block", 1);
			
			Map<String, Integer> pagechoice2 = new HashMap<String, Integer>();
			pagechoice2.put("inline-block", 2);
			
			Map<String, Integer> pagechoice3 = new HashMap<String, Integer>();
			pagechoice3.put("inline-block", 3);
			
			Map<String, Integer> pagechoice4 = new HashMap<String, Integer>();
			pagechoice4.put("inline-block", 4);
			
			Map<String, Integer> pagechoice5 = new HashMap<String, Integer>();
			pagechoice5.put("inline-block", 5);
			
			Map<String, Integer> pagechoice6 = new HashMap<String, Integer>();
			pagechoice6.put("inline-block", 6);
			
			Map<String, Integer> pagechoice7 = new HashMap<String, Integer>();
			pagechoice7.put("none", 7);
			
			Map<String, Integer> pagechoice8 = new HashMap<String, Integer>();
			pagechoice8.put("inline-block", num);
			
			request.setAttribute("page", new Page("inline-block", pagechoice1, "none", pagechoice2, pagechoice3, pagechoice4, pagechoice5, pagechoice6, "inline-block", pagechoice7, "none", pagechoice8));
			request.setAttribute("activepage", page_num);
		}else if(page_num == 1) {
			Map<String, Integer> pagechoice1 = new HashMap<String, Integer>();
			pagechoice1.put("inline-block", 1);
			
			Map<String, Integer> pagechoice2 = new HashMap<String, Integer>();
			pagechoice2.put("inline-block", 2);
			
			Map<String, Integer> pagechoice3 = new HashMap<String, Integer>();
			pagechoice3.put("inline-block", 3);
			
			Map<String, Integer> pagechoice4 = new HashMap<String, Integer>();
			pagechoice4.put("inline-block", 4);
			
			Map<String, Integer> pagechoice5 = new HashMap<String, Integer>();
			pagechoice5.put("inline-block", 5);
			
			Map<String, Integer> pagechoice6 = new HashMap<String, Integer>();
			pagechoice6.put("inline-block", 6);
			
			Map<String, Integer> pagechoice7 = new HashMap<String, Integer>();
			pagechoice7.put("none", 7);
			
			Map<String, Integer> pagechoice8 = new HashMap<String, Integer>();
			pagechoice8.put("inline-block", num);
			request.setAttribute("activepage", page_num);
			request.setAttribute("page", new Page("none", pagechoice1, "none", pagechoice2, pagechoice3, pagechoice4, pagechoice5, pagechoice6, "inline-block", pagechoice7, "none", pagechoice8));
		}else if(page_num==5) {
			Map<String, Integer> pagechoice1 = new HashMap<String, Integer>();
			pagechoice1.put("inline-block", 1);
			
			Map<String, Integer> pagechoice2 = new HashMap<String, Integer>();
			pagechoice2.put("inline-block", 2);
			
			Map<String, Integer> pagechoice3 = new HashMap<String, Integer>();
			pagechoice3.put("inline-block", 3);
			
			Map<String, Integer> pagechoice4 = new HashMap<String, Integer>();
			pagechoice4.put("inline-block", 4);
			
			Map<String, Integer> pagechoice5 = new HashMap<String, Integer>();
			pagechoice5.put("inline-block", 5);
			
			Map<String, Integer> pagechoice6 = new HashMap<String, Integer>();
			pagechoice6.put("inline-block", 6);
			
			Map<String, Integer> pagechoice7 = new HashMap<String, Integer>();
			pagechoice7.put("inline-block", 7);
			
			Map<String, Integer> pagechoice8 = new HashMap<String, Integer>();
			pagechoice8.put("inline-block", num);
			request.setAttribute("activepage", page_num);
			request.setAttribute("page", new Page("inline-block", pagechoice1, "none", pagechoice2, pagechoice3, pagechoice4, pagechoice5, pagechoice6, "none", pagechoice7, "inline-block", pagechoice8));
		}else if(page_num>5) {
			Map<String, Integer> pagechoice1 = new HashMap<String, Integer>();
			pagechoice1.put("inline-block", 1);
			
			Map<String, Integer> pagechoice2 = new HashMap<String, Integer>();
			pagechoice2.put("inline-block", page_num-2);
			
			Map<String, Integer> pagechoice3 = new HashMap<String, Integer>();
			pagechoice3.put("inline-block", page_num-1);
			
			Map<String, Integer> pagechoice4 = new HashMap<String, Integer>();
			pagechoice4.put("inline-block", page_num);
			
			Map<String, Integer> pagechoice5 = new HashMap<String, Integer>();
			pagechoice5.put("inline-block", page_num+1);
			
			Map<String, Integer> pagechoice6 = new HashMap<String, Integer>();
			pagechoice6.put("inline-block", page_num+2);
			
			Map<String, Integer> pagechoice7 = new HashMap<String, Integer>();
			pagechoice7.put("none", 7);
			
			Map<String, Integer> pagechoice8 = new HashMap<String, Integer>();
			pagechoice8.put("inline-block", num);
			request.setAttribute("activepage", page_num);
			request.setAttribute("page", new Page("inline-block", pagechoice1, "inline-block", pagechoice2, pagechoice3, pagechoice4, pagechoice5, pagechoice6, "none", pagechoice7, "inline-block", pagechoice8));
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void dofilter(String method,String type) {
		if(method!=null && type!=null) {
			filter_list.put(method, type);
		}
		
		Set<String> keySet = filter_list.keySet();
		Collection<String> values = filter_list.values();
		System.out.println(allbook);
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
	}
	protected void getBookByType(String type) throws ServletException, IOException {
	
		List<book> attribute2 = new ArrayList<book>();
		if(!type.equals("全部作品")) {
			for (book book : allbook) {
				if(book.getBook_type().contains(type)) {
					attribute2.add(book);
				}
			}
			allbook = attribute2;
		}
	}
	
	protected void getBookByFirstWord(String word) throws ServletException, IOException {
		if(word.equals("全部")) {
			return;
		}
		List<book> books = new ArrayList<book>();
		Bopomofo4j.local();
		
		for (book book : allbook) {
			String book_name = book.getBook_name();
			String pinyin = Bopomofo4j.pinyin(book_name, 2, false, false, "");
			char fistword = pinyin.charAt(0);
			char trueword = word.charAt(0);
			
			if(fistword==trueword) {//这本书的书名首字母和传过来的首字母一样
				books.add(book);
			}
		}
		allbook = books;
	}
	
	protected void getbook_bykeyword(String key) throws Exception {
		allbook = service.getbook_bykeyword(key);
	}
}
