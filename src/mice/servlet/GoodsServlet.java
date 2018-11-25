package mice.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import mice.bean.Goods;
import mice.dao.GoodsDAO;

public class GoodsServlet extends BaseServlet {
	public String li(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		return ("admin/goods.jsp");
	}

	public String list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		Goods bean = new Goods();
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("goodslist", goodsDao.total());
		return ("admin/goods.jsp");
	}

	public String add(HttpServletRequest request, HttpServletResponse response) {

		Goods bean = new Goods();
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
				goodsDao.add(bean);
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
					String folder = request.getSession().getServletContext().getRealPath("img/goods");
					File file = new File(folder, filename);
					file.getParentFile().mkdirs();
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

		return "@admin_goods_list";

	}

	public String updata(HttpServletRequest request, HttpServletResponse response) {
		Goods bean = new Goods();
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setName(request.getParameter("name"));
		bean.setPrice(Float.parseFloat(request.getParameter("price")));
		GoodsDAO.updata(bean);

		request.setAttribute("status", "修改成功");

		return "@admin_goods_list";

	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		GoodsDAO.delete(id);

		request.setAttribute("status", "删除成功");
		return "@admin_goods_list";

	}

	public String serch(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String goodsName = request.getParameter("goodsName");
		List<Goods> beans = GoodsDAO.get(goodsName);
		request.setAttribute("goodslist", beans);
		System.out.println(goodsName);
		return "admin/goods.jsp";
	}

	public String getimg(HttpServletRequest request, HttpServletResponse response) {
		int MAX_FILE_SIZE = 1024 * 1024 * 10;
		String id = request.getParameter("id");
		System.out.println(id);
		String folder = request.getSession().getServletContext().getRealPath("img/goods");

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "!admin_goods_list";

	}
}