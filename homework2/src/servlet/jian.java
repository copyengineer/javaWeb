package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.book;

/**
 * ����ĳһ����Ʒ������
 * @author 22364
 *
 */
public class jian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public jian() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    class num{
    	public int nums;

		public num(int nums) {
			super();
			this.nums = nums;
		}
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, book> car = (Map<String, book>)session.getAttribute("car");
		book books = car.get(request.getParameter("name"));
		int n = books.getNum();
		int price = books.getPrice();
		n--;
		books.setNum(n);
		car.remove(request.getParameter("name"));
		car.put(request.getParameter("name"), books);
		num nn = new num(n);
		Gson gson = new Gson();
		String json = gson.toJson(nn);
		System.out.println(json);
		
		//�ܼ�����һ
		Integer attribute = (Integer)session.getAttribute("count");
		attribute--;
		session.setAttribute("count", attribute);
		//�����һ��Ϊ0�������Ƴ�����Ʒ
		if(n == 0) {
			car.remove(request.getParameter("name"));
		}
		
		//�ܼ۸����
		Integer attribute2 = (Integer)session.getAttribute("cost");
		attribute2-=price;
		session.setAttribute("cost", attribute2);
		
		response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
