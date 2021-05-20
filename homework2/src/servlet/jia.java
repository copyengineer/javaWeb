package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.book;

public class jia extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public jia() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String bookname = request.getParameter("name");
		System.out.println(bookname);
		//数量加一
		Map<String, book> map = (Map<String, book>)session.getAttribute("car");
		book book = null;
		int price;
		try {
			book = map.get(bookname);
			price = book.getPrice();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Gson gson = new Gson();
			String json = gson.toJson(new book() );
			response.getWriter().write(json);
			e.printStackTrace();
			return;
		}
		System.out.println(11111);
		
		int num = book.getNum();
		num++;
		book.setNum(num);
		//总件数加一
		Integer attribute = (Integer)session.getAttribute("count");
		attribute++;
		session.setAttribute("count", attribute);
		//总价格增加
		Integer attribute2 = (Integer)session.getAttribute("cost");
		attribute2+=price;
		session.setAttribute("cost", attribute2);
		
		Gson gson = new Gson();
		String json = gson.toJson(book);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
