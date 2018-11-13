package mic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Goods;
import mice.dao.GoodsDAO;


public class GoodsAddServlet  extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Goods bean=new Goods();
		request.setCharacterEncoding("UTF-8");
		bean.setName(request.getParameter("name"));
		bean.setPrice(Float.parseFloat(request.getParameter("price")));
		GoodsDAO.add(bean);
		request.setAttribute("status", "aaaa");
		request.getRequestDispatcher("/admin/admin_goods.jsp").forward(request, response);

	}
}
