package mice.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Goods;
import mice.dao.GoodsDAO;

public class GoodsListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("goodslist", GoodsDAO.total());
		request.getRequestDispatcher("/goods.jsp").forward(request, response);
	}
}
