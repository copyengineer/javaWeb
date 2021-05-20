package servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

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
		//1����ѯ���ݿ⣬��ȡȫ��ͼ����Ϣ������session����
		List<book> booklist = bim.getAllBook();
		ses.setAttribute("allBookInfo", booklist);
		ses.setAttribute("allBookInfo2", booklist);//��������ͼ����Ϣ
		ses.setAttribute("live", new HashMap<String, String>());
		//2��ת����������index.jspҳ��
		request.getRequestDispatcher("/Pages/pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}