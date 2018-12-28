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
<<<<<<< HEAD
}
=======

	public static String setImage(HttpServletRequest request, HttpServletResponse response) {
		Product bean = new Product();
		// DiskFileItemFactory factory = new DiskFileItemFactory();
		String filename = null;
		// 默认后缀名
		String postfix = ".jpg";
		String turename = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			factory.setSizeThreshold(1024 * 1024 * 10);
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
				String name = items.get(0).getString("utf-8");
				String price = items.get(1).getString("utf-8");
				System.out.println("name:" + name);
				bean.setName(name);
				bean.setPrice(Float.parseFloat(price));
				ProductDAO.add(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					turename = item.getName();
					turename = new String(turename.getBytes("GBK"), "UTF-8");
					filename = bean.getId() + ".jpg";
					String folder = request.getSession().getServletContext().getRealPath("img/product");

					File file = new File(folder, filename);
					file.getParentFile().mkdirs();
					System.out.println("!!folder:" + folder);
					InputStream in = item.getInputStream();
					FileOutputStream fio = new FileOutputStream(file);
					byte byt[] = new byte[1024 * 1024 * 10];
					int length = 0;
					while ((length = in.read(byt)) != -1) {
						fio.write(byt, 0, length);
					}
					fio.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "!";
	}
}
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
