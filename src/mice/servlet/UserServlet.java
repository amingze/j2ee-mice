
package mice.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.HtmlUtils;

import mice.bean.User;

public class UserServlet extends BaseBackServlet {

	public String list(HttpServletRequest request, HttpServletResponse response) {
		List<User> us = userDAO.list();
		int total = userDAO.getTotal();

		request.setAttribute("us", us);

		return "admin/listUser.jsp";
	}

	public String add(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	public String edit(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	public String update(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
