package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.book;


public class addToCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addToCar() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//判断用户有没有登陆
		if(request.getSession().getAttribute("user") == null) {//没有登陆
			response.sendRedirect("/homework2/shopping/login.jsp");//跳到登陆界面
		}else {
			//持久化session
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("JSESSIONID")) {
					//cookie.setValue("123");//用户在不同的浏览器上登陆购物车信息都能同步，这个123可以是用户名，手机号等唯一的东西，用户需要访问购物车时必须登陆。
					//cookie.setValue("456");
					cookie.setMaxAge(24*60*60*7);//购物车明细只保留七天
					
					response.addCookie(cookie);
					
				}
			}
			
			HttpSession session = request.getSession();
			System.out.println(session.getId());
			System.out.println(session.isNew());
			Map<String, book> carMap = null;
			response.setHeader("Pragma", "no-cache");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			//解决每个用户都有“自己的”购物车
			if(session.getAttribute("car") == null) {//用户第一次登陆购物车没有东西
				carMap = new HashMap<String, book>();
				System.out.println("用户第一次登陆系统");
				session.setAttribute("count", 1);
				session.setAttribute("cost", price);
			}else {
				carMap = (Map<String, book>)session.getAttribute("car");
				int count = (int)session.getAttribute("count");
				count++;
				session.setAttribute("count", count);//购物车里的商品总数+1
				int cost = (int)session.getAttribute("cost");
				cost+=price;
				session.setAttribute("cost", cost);//购物车商品总金额改变（加上当前商品价格）
			}
			
			book b = new book(name, price,1);
			if(!carMap.containsKey(name)) {
				carMap.put(name, b);
				System.out.println(12);
			}else {
				book b2 = carMap.get(name);
				
				int num = b2.getNum();
				System.out.println(num+"addtocar");
				num+=1;
				carMap.remove(name);
				book b3 =new book(name, price, num);
				carMap.put(name, b3);
			}
			System.out.println(carMap);
			session.setAttribute("car", carMap);
			request.getRequestDispatcher("/shopping/buy.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
