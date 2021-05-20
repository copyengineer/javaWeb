package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.users;
import service.userService;
import service.serviceImpl.userServiceImpl;


public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	userService service = new userServiceImpl();
	
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		users user1 = new users(username, phone, password);
		
		users user2 = service.getuserByPhone(user1);

		if(user2 == null) {//该手机号没有被注册过
			
			
			//1、注册成功，重定向
			response.sendRedirect("/onlineBookStore/Pages/index.jsp");
			//2、更新数据库中的users表
			service.adduser(user1);
		}else {//该手机号被注册过了
			System.out.println("cnm");
			request.setAttribute("msg2", "该手机号已经被注册过了");
			request.setAttribute("sty", "block");//使界面停留再注册页
			request.setAttribute("sty2", "#E0ECF8");//保持样式（背景颜色）不变
			request.getRequestDispatcher("/Pages/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
