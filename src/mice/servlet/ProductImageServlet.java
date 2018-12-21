
package mice.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Product;
import mice.bean.ProductImage;
import mice.dao.ProductImageDAO;
import mice.util.ImageUtil;

public class ProductImageServlet extends BaseBackServlet {
	public String add(HttpServletRequest request, HttpServletResponse response) {
		// 上传文件输入流
		InputStream is = null;
		// 提交上传文件时的其他参数
		Map<String, String> params = new HashMap<>();

		// 解析上传
		is = parseUpload(request, params);

		// 根据上传的参数生成productImage对象

		int pid = Integer.parseInt(params.get("pid"));
		Product p = productDAO.get(pid);

		ProductImage pi = new ProductImage();

		pi.setProduct(p);
		productImageDAO.add(pi);

		// 生成文件
		String fileName = pi.getId() + ".jpg";
		String imageFolder;

		imageFolder = request.getSession().getServletContext().getRealPath("img/productSingle");
		File f = new File(imageFolder, fileName);
		f.getParentFile().mkdirs();

		// 复制文件
		try {
			if (null != is && 0 != is.available()) {
				try (FileOutputStream fos = new FileOutputStream(f)) {
					byte b[] = new byte[1024 * 1024];
					int length = 0;
					while (-1 != (length = is.read(b))) {
						fos.write(b, 0, length);
					}
					fos.flush();
					// 文件保存
					BufferedImage img = ImageUtil.change2jpg(f);
					ImageIO.write(img, "jpg", f);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "@admin_productImage_list?pid=" + p.getId();
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductImage pi = productImageDAO.get(id);
		productImageDAO.delete(id);
		String imageFolder_single = request.getSession().getServletContext().getRealPath("img/productSingle");
		File f_single = new File(imageFolder_single, pi.getId() + ".jpg");
		f_single.delete();

		return "@admin_productImage_list?pid=" + pi.getProduct().getId();
	}

	public String edit(HttpServletRequest request, HttpServletResponse response) {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String edit = request.getParameter("edit");

		Product p = productDAO.get(pid);
		productDAO.edit(pid, edit);
		List<ProductImage> pisSingle = productImageDAO.list(p);
		System.out.println(edit);
		request.setAttribute("p", p);
		request.setAttribute("pisSingle", pisSingle);
		request.setAttribute("editor", edit);

		return "admin/listProductImage.jsp";

	}

	public String update(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	public String list(HttpServletRequest request, HttpServletResponse response) {
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product p = productDAO.get(pid);
		List<ProductImage> pisSingle = productImageDAO.list(p);

		System.out.println();
		request.setAttribute("p", p);
		request.setAttribute("pisSingle", pisSingle);

		return "admin/listProductImage.jsp";
	}

}
