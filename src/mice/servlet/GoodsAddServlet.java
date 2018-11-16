package mice.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Goods;
import mice.dao.GoodsDAO;

public class GoodsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Goods bean = new Goods();
		request.setCharacterEncoding("UTF-8");
		String price = request.getParameter("price");
		if (price == null) {
			price = "0.01";
		}

		bean.setPrice(Float.parseFloat(price));
		bean.setName(request.getParameter("name"));
		GoodsDAO.add(bean);
		request.setAttribute("status", "aaaa");
		request.getRequestDispatcher("/admin_goods").forward(request, response);

	}
}
