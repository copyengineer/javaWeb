package servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.Page;
import bean.book;
import service.book_interface;
import service.impl.book_impl;

/**
 * Servlet implementation class client_servlet
 */
public class client_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    book_interface bim = new book_impl();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		//1、查询数据库，获取全部图书信息，放入session域中
		List<book> booklist = bim.getAllBook();
		request.setAttribute("allBookInfo", booklist);
		ses.setAttribute("allBookInfo2", booklist);//备份所有图书信息
		request.setAttribute("live", new HashMap<String, String>());
		
		
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
		pagechoice8.put("inline-block", booklist.size()%2==0?booklist.size()/2:booklist.size()/2+1);
		request.setAttribute("page", new Page("none",pagechoice1, "none", pagechoice2, pagechoice3, pagechoice4,pagechoice5, pagechoice6, "inline-block", pagechoice7, "none", pagechoice8));
		request.getSession().setAttribute("page", new Page("none",pagechoice1, "none", pagechoice2, pagechoice3, pagechoice4,pagechoice5, pagechoice6, "inline-block", pagechoice7, "none", null));
		
		//2、转发到真正的index.jsp页面
		request.getRequestDispatcher("/Pages/pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
