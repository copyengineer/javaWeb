package servlet;


import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import bean.book;
import dao.JDBCTools;
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
		//2、转发到真正的index.jsp页面
		request.getRequestDispatcher("/Pages/pages/index.jsp").forward(request, response);
		
		//Connection connection = JDBCTools.tL.get();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
