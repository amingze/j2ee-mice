package mice.servlet;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mice.bean.Category;
import mice.bean.Product;

public class ProductServlet extends BaseBackServlet {

	public String add(HttpServletRequest request, HttpServletResponse response) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid);

		String name = request.getParameter("name");
		String subTitle = request.getParameter("subTitle");

		float promotePrice = Float.parseFloat(request.getParameter("promotePrice"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		Product p = new Product();

		p.setCategory(c);
		p.setName(name);
		p.setSubTitle(subTitle);
		p.setPromotePrice(promotePrice);
		p.setStock(stock);

		productDAO.add(p);
		return "@admin_product_list?cid=" + cid;
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = productDAO.get(id);
		productDAO.delete(id);
		return "@admin_product_list?cid=" + p.getCategory().getId();
	}

	public String edit(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = productDAO.get(id);
		request.setAttribute("p", p);
		return "admin/editProduct.jsp";
	}

	public String update(HttpServletRequest request, HttpServletResponse response) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid);

		int id = Integer.parseInt(request.getParameter("id"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		float promotePrice = Float.parseFloat(request.getParameter("promotePrice"));
		String subTitle = request.getParameter("subTitle");
		String name = request.getParameter("name");

		Product p = new Product();

		p.setName(name);
		p.setSubTitle(subTitle);

		p.setPromotePrice(promotePrice);
		p.setStock(stock);
		p.setId(id);
		p.setCategory(c);

		productDAO.update(p);
		return "@admin_product_list?cid=" + p.getCategory().getId();
	}

	public String list(HttpServletRequest request, HttpServletResponse response) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid);

		List<Product> ps = productDAO.list(cid);

		int total = productDAO.getTotal(cid);

		request.setAttribute("ps", ps);
		request.setAttribute("c", c);

		return "admin/listProduct.jsp";
	}
}
