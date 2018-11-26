package mice.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import mice.bean.Product;
import mice.dao.ProductDAO;

public class ProductServlet extends BackBaseServlet {
	public String li(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		return ("admin/product.jsp");
	}

	public String list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		Product bean = new Product();
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("productlist", ProductDao.total());
		return ("admin/product.jsp");
	}

	public String add(HttpServletRequest request, HttpServletResponse response) {

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
				ProductDao.add(bean);
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

		request.setAttribute("status", "添加成功");

		return "@admin_product_list";

	}

	public String updata(HttpServletRequest request, HttpServletResponse response) {
		Product bean = new Product();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setName(request.getParameter("name"));
		bean.setPrice(Float.parseFloat(request.getParameter("price")));
		ProductDAO.updata(bean);

		request.setAttribute("status", "修改成功");

		return "@admin_product_list";

	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO.delete(id);

		request.setAttribute("status", "删除成功");
		return "@admin_product_list";

	}

	public String serch(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String ProductName = request.getParameter("productName");
		List<Product> beans = ProductDAO.get(ProductName);
		request.setAttribute("productList", beans);
		System.out.println(ProductName);
		return "admin/product.jsp";
	}

	public String getimg(HttpServletRequest request, HttpServletResponse response) {
		int MAX_FILE_SIZE = 1024 * 1024 * 10;
		String id = request.getParameter("id");
		System.out.println(id);
		String folder = request.getSession().getServletContext().getRealPath("img/product");

		InputStream inputStream;
		try {
			inputStream = new FileInputStream(folder + "//" + id);

			OutputStream outputStream = response.getOutputStream();
			byte[] byt = new byte[MAX_FILE_SIZE];
			int len;
			while ((len = inputStream.read(byt)) != -1) {
				outputStream.write(byt, 0, len);
			}
			outputStream.flush();
			outputStream.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "!admin_product_list";

	}
}