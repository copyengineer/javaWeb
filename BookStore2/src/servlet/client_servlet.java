package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println(123);
		//1、查询数据库，获取全部图书信息，放入request域中
		List<book> booklist = bim.getAllBook();
		request.setAttribute("allBookInfo", booklist);
		//2、转发到真正的index.jsp页面
		request.getRequestDispatcher("/Pages/pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
