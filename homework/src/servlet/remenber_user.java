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
		
		if(parameter1 == null || (!parameter1.equals(parameter2) && !parameter1.equals(""))){//����û������������룬���߲���½ֱ�ӷ��ʸ�ҳ�棬���ض���
			response.sendRedirect("login.jsp");
		}else if(parameter!=null && parameter.equals("on")){//����û���ѡ�˼�ס�û���������,parameter!=null�������ǰ�棬��Ȼ���ܷ����쳣
			user u = new user(parameter1,parameter2);
			set.add(u);//�û�����ͬ���ܴ���set��
		
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {//ͨ���־û������cookie���־û�session����
				if(cookie.getName().equals("JSESSIONID")) {
					cookie.setMaxAge(24*60*60*7);
					response.addCookie(cookie);
				}
				
			}
			
			session.setAttribute("acount_info", set);
			System.out.println(session.getAttribute("acount_info"));
			System.out.println(1);
			session.setAttribute("now_user", u);//�洢���һ�ε�½�����û����´ε�½ʱ�Զ������һ���û����˺ź�����
		}
		
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
