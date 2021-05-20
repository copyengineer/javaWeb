package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class login_servlet
 */
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("remenber");
		System.out.println(parameter);
		HttpSession session2 = request.getSession();
		System.out.println(session2.isNew());
		if(parameter.equals("on") && parameter!=null) {
			String parameter2 = request.getParameter("username");
			String parameter3 = request.getParameter("password");
			HttpSession session = request.getSession();
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("JSESSIONID")) {
					System.out.println(cookie);
					cookie.setMaxAge(30);
					response.addCookie(cookie);
				}
				
			}
			List<String> user = new ArrayList<String>();
			user.add(parameter2);
			user.add(parameter3);
			session.setAttribute("user", user);
		}
		
		request.getRequestDispatcher("2.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
