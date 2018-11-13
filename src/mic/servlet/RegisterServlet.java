package mic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.User;
import mice.dao.UserDAO;

public class RegisterServlet  extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		User bean=new User();
		request.setCharacterEncoding("UTF-8");
		bean.setName(request.getParameter("name"));
		bean.setPasswd(request.getParameter("passwd"));
		try {
			if(UserDAO.isNoExist(bean.getName())) {
				UserDAO.add(bean);
				request.setAttribute("status", "注册成功");
			}else {
				request.setAttribute("status", "名字已存在");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
}
