package mice.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import mice.bean.Goods;
import mice.dao.GoodsDAO;

public class ProductSevlet {

	String Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Goods bean = new Goods();
		request.setCharacterEncoding("UTF-8");
		bean.setName(request.getParameter("name"));
		bean.setPrice(Float.parseFloat(request.getParameter("price")));
		GoodsDAO.add(bean);
		request.setAttribute("status", "添加成功");
		return "admin_goods.jsp";
	}

	String updata() {

		return null;
	}

	String delete() {
		return null;
	}

	String get() {
		return null;
	}
}
