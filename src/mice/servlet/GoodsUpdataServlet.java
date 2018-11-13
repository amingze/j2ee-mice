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


public class GoodsUpdataServlet  extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Goods bean=new Goods();
		request.setCharacterEncoding("UTF-8");
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setName(request.getParameter("name"));
		bean.setPrice(Float.parseFloat(request.getParameter("price")));
		GoodsDAO.updata(bean);
		request.setAttribute("status", "添加成功");
		
		request.getRequestDispatcher("/admin_goods").forward(request, response);

	}
}
