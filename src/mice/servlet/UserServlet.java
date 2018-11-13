package mic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.User;
import mice.dao.UserDAO;

public class UserServlet  extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		UserDAO bean=new UserDAO();
		List<User> beans=bean.total();
		request.setAttribute("users", beans);
		request.getRequestDispatcher("admin/user.jsp").forward(request, response);
		
	}
}
