package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.users;
import service.userService;
import service.serviceImpl.userServiceImpl;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public loginServlet() {
        super();
    }
    
    userService service = new userServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		users user1 = new users(username, phone, password);
		
		boolean user2 = service.getuser(user1);

		if(user2 == false) {//数据库中不存在该用户，转发
			request.setAttribute("msg", "请检查账号或密码是否正确");
			request.getRequestDispatcher("/Pages/index.jsp").forward(request, response);
		}else {//数据库中存在该用户，重定向
			response.sendRedirect("/onlineBookStore/Pages/NewFile.html");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
