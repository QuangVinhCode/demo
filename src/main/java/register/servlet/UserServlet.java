package register.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import java.util.*;

import register.dao.UserDAO;
import register.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/UserServlet","/UserServlet/create","/UserServlet/update"
	,"/UserServlet/delete","/UserServlet/edit","/UserServlet/reset"})
public class UserServlet extends HttpServlet {     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		User user = null;
		if (url.contains("delete")) {
			delete(request, response); 
			user = new User();
			request.setAttribute("user", user);
		}else if (url.contains("edit")) {
			edit(request, response);
		}else if (url.contains("reset")) {
			user = new User();
			request.setAttribute("user", user);
		}
		
		
		findAll(request, response);
		
		
		request.getRequestDispatcher("/user.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String url = request.getRequestURL().toString();
		
		if (url.contains("create"))
		{
			insert(request, response);
		}else if (url.contains("delete")) {
			delete(request, response); 
			request.setAttribute("user", new User());
		}else if (url.contains("update")) {
			update(request, response);
		}else if (url.contains("reset")) {
			request.setAttribute("user", new User());
		}
		
		findAll(request, response);
		
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDAO dao = new UserDAO();
			dao.insert(user);
			
			request.setAttribute("message", "Them Thanh Cong!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Error:" + e.getMessage());
		}
	
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
					
			UserDAO dao = new UserDAO();
			
			List<User> list = dao.findAll();
			
			request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Error:" + e.getMessage());
		}
	
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			String userld = request.getParameter("userld");
			
			UserDAO dao = new UserDAO();
			User user = dao.findByID(userld);
			
			request.setAttribute("user",user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Error:" + e.getMessage());
		}
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDAO dao = new UserDAO();
			dao.updeate(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "Cap nhat thanh Cong!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Error:" + e.getMessage());
		}
	
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			String userld = request.getParameter("userld");
			UserDAO dao = new UserDAO();
			dao.delete(userld);
			
			request.setAttribute("message", "Xoa Thanh Cong!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Error:" + e.getMessage());
		}
	
	}
}
