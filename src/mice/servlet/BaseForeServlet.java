
package mice.servlet;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.dao.CategoryDAO;
import mice.dao.OrderDAO;
import mice.dao.OrderItemDAO;
import mice.dao.ProductDAO;
import mice.dao.ProductImageDAO;

import mice.dao.ReviewDAO;
import mice.dao.UserDAO;

public class BaseForeServlet extends HttpServlet {

	protected CategoryDAO categoryDAO = new CategoryDAO();
	protected OrderDAO orderDAO = new OrderDAO();
	protected OrderItemDAO orderItemDAO = new OrderItemDAO();
	protected ProductDAO productDAO = new ProductDAO();
	protected ProductImageDAO productImageDAO = new ProductImageDAO();

	protected ReviewDAO reviewDAO = new ReviewDAO();
	protected UserDAO userDAO = new UserDAO();

	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {

			String method = (String) request.getAttribute("method");

			Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class);

			String redirect = m.invoke(this, request, response).toString();

			if (redirect.startsWith("@"))
				response.sendRedirect(redirect.substring(1));
			else if (redirect.startsWith("%"))
				response.getWriter().print(redirect.substring(1));
			else
				request.getRequestDispatcher(redirect).forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
