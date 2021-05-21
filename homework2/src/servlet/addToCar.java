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
		//�ж��û���û�е�½
		if(request.getSession().getAttribute("user") == null) {//û�е�½
			response.sendRedirect("/homework2/shopping/login.jsp");//������½����
		}else {
			//�־û�session
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("JSESSIONID")) {
					//cookie.setValue("123");//�û��ڲ�ͬ��������ϵ�½���ﳵ��Ϣ����ͬ�������123�������û������ֻ��ŵ�Ψһ�Ķ������û���Ҫ���ʹ��ﳵʱ�����½��
					//cookie.setValue("456");
					cookie.setMaxAge(24*60*60*7);//���ﳵ��ϸֻ��������
					
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
			
			//���ÿ���û����С��Լ��ġ����ﳵ
			if(session.getAttribute("car") == null) {//�û���һ�ε�½���ﳵû�ж���
				carMap = new HashMap<String, book>();
				System.out.println("�û���һ�ε�½ϵͳ");
				session.setAttribute("count", 1);
				session.setAttribute("cost", price);
			}else {
				carMap = (Map<String, book>)session.getAttribute("car");
				int count = (int)session.getAttribute("count");
				count++;
				session.setAttribute("count", count);//���ﳵ�����Ʒ����+1
				int cost = (int)session.getAttribute("cost");
				cost+=price;
				session.setAttribute("cost", cost);//���ﳵ��Ʒ�ܽ��ı䣨���ϵ�ǰ��Ʒ�۸�
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
