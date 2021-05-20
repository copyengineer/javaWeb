package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Çå¿Õ¹ºÎï³µ
 * @author 22364
 *
 */
public class clear_car extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public clear_car() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("car");
		session.removeAttribute("count");
		session.removeAttribute("cost");
		request.getRequestDispatcher("/shopping/car.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
