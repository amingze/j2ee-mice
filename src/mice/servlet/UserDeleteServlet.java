package mice.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.User;
import mice.dao.UserDAO;

public class UserDeleteServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		UserDAO.delete(id);
		request.setAttribute("status", "删除成功");
		request.getRequestDispatcher("admin_user").forward(request, response);
		;
	}
}
