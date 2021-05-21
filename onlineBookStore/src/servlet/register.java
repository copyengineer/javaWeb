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

		if(user2 == null) {//���ֻ���û�б�ע���
			
			
			//1��ע��ɹ����ض���
			response.sendRedirect("/onlineBookStore/Pages/index.jsp");
			//2���������ݿ��е�users��
			service.adduser(user1);
		}else {//���ֻ��ű�ע�����
			System.out.println("cnm");
			request.setAttribute("msg2", "���ֻ����Ѿ���ע�����");
			request.setAttribute("sty", "block");//ʹ����ͣ����ע��ҳ
			request.setAttribute("sty2", "#E0ECF8");//������ʽ��������ɫ������
			request.getRequestDispatcher("/Pages/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
