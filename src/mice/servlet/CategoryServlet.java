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

import mice.bean.Category;
import mice.util.ImageUtil;

public class CategoryServlet extends BaseBackServlet {

	public String add(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = new HashMap<>();
		InputStream is = super.parseUpload(request, params);

		String name = params.get("name");
		Category c = new Category();
		c.setName(name);
		categoryDAO.add(c);

		File imageFolder = new File(request.getSession().getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder, c.getId() + ".jpg");
		System.out.println(file);
		try {
			if (null != is && 0 != is.available()) {
				try (FileOutputStream fos = new FileOutputStream(file)) {
					byte b[] = new byte[1024 * 1024];
					int length = 0;
					while (-1 != (length = is.read(b))) {
						fos.write(b, 0, length);
					}
					fos.flush();
					// 通过如下代码，把文件保存为jpg格式
					BufferedImage img = ImageUtil.change2jpg(file);
					ImageIO.write(img, "jpg", file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "@admin_category_list";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		categoryDAO.delete(id);
		return "@admin_category_list";
	}

	public String edit(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Category c = categoryDAO.get(id);
		request.setAttribute("c", c);
		return "admin/editCategory.jsp";
	}

	public String update(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = new HashMap<>();
		InputStream is = super.parseUpload(request, params);
		String name = params.get("name");
		int id = Integer.parseInt(params.get("id"));

		Category c = new Category();
		c.setId(id);
		c.setName(name);
		categoryDAO.update(c);

		File imageFolder = new File(request.getSession().getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder, c.getId() + ".jpg");
		file.getParentFile().mkdirs();

		try {
			if (null != is && 0 != is.available()) {
				try (FileOutputStream fos = new FileOutputStream(file)) {
					byte b[] = new byte[1024 * 1024];
					int length = 0;
					while (-1 != (length = is.read(b))) {
						fos.write(b, 0, length);
					}
					fos.flush();
					// 通过如下代码，把文件保存为jpg格式
					BufferedImage img = ImageUtil.change2jpg(file);
					ImageIO.write(img, "jpg", file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "@admin_category_list";

	}

	public String list(HttpServletRequest request, HttpServletResponse response) {
		List<Category> cs = categoryDAO.list();

		int total = categoryDAO.getTotal();

		request.setAttribute("thecs", cs);

		return "admin/listCategory.jsp";
	}
}
