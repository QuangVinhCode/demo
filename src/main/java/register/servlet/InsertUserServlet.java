package register.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import register.dao.UserDAO;
import register.model.User;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 User user = new User();
			 user.setUserld("1");
			 user.setPassword("1");
			 user.setFullname("1 an");
			 
			 UserDAO dao = new UserDAO();
			 dao.insert(user);
			 
			 System.out.println("inset thanh cong");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
