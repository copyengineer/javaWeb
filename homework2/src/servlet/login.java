package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.car_of_user;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private car_of_user user = new car_of_user();
    
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals(password)) {//用户名等于密码就可以登陆
			request.getSession().setAttribute("user", username);
			
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("JSESSIONID")) {
					//掉用数据库，将jsessionid的值存入数据库
					user.saveMyCar(cookie.getValue());
				}
			}
			request.getRequestDispatcher("/shopping/buy.jsp").forward(request, response);;
		}else {
			response.getWriter().write("登陆失败");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
