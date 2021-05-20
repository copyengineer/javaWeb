package servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.user;

public class remenber_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Set<user> set = new HashSet<user>();
    
    public remenber_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("remenber");
		String parameter1 = request.getParameter("username");
		String parameter2 = request.getParameter("password");
		HttpSession session = request.getSession();
		
		if(parameter1 == null || (!parameter1.equals(parameter2) && !parameter1.equals(""))){//如果用户名不等于密码，或者不登陆直接访问该页面，则重定向
			response.sendRedirect("login.jsp");
		}else if(parameter!=null && parameter.equals("on")){//如果用户勾选了记住用户名和密码,parameter!=null必须放在前面，不然可能发生异常
			user u = new user(parameter1,parameter2);
			set.add(u);//用户名相同不能存入set中
		
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {//通过持久化特殊的cookie来持久化session对象
				if(cookie.getName().equals("JSESSIONID")) {
					cookie.setMaxAge(24*60*60*7);
					response.addCookie(cookie);
				}
				
			}
			
			session.setAttribute("acount_info", set);
			System.out.println(session.getAttribute("acount_info"));
			System.out.println(1);
			session.setAttribute("now_user", u);//存储最后一次登陆的用用户。下次登陆时自动填充上一个用户的账号和密码
		}
		
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
