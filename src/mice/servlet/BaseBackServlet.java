
package mice.servlet;

import java.io.InputStream;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import mice.dao.CategoryDAO;
import mice.dao.OrderDAO;
import mice.dao.OrderItemDAO;
import mice.dao.ProductDAO;
import mice.dao.ProductImageDAO;

import mice.dao.ReviewDAO;
import mice.dao.UserDAO;

public abstract class BaseBackServlet extends HttpServlet {

	public abstract String add(HttpServletRequest request, HttpServletResponse response);

	public abstract String delete(HttpServletRequest request, HttpServletResponse response);

	public abstract String edit(HttpServletRequest request, HttpServletResponse response);

	public abstract String update(HttpServletRequest request, HttpServletResponse response);

	public abstract String list(HttpServletRequest request, HttpServletResponse response);

	protected CategoryDAO categoryDAO = new CategoryDAO();
	protected OrderDAO orderDAO = new OrderDAO();
	protected OrderItemDAO orderItemDAO = new OrderItemDAO();
	protected ProductDAO productDAO = new ProductDAO();
	protected ProductImageDAO productImageDAO = new ProductImageDAO();

	protected ReviewDAO reviewDAO = new ReviewDAO();
	protected UserDAO userDAO = new UserDAO();

	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {

			/* 反射调用 */
			String method = (String) request.getAttribute("method");
			Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class);
			String redirect = m.invoke(this, request, response).toString();

			if (redirect.startsWith("@"))
				response.sendRedirect(redirect.substring(1));
			else if (redirect.startsWith("%"))
				response.getWriter().print(redirect.substring(1));
			else
				request.getRequestDispatcher(redirect).forward(request, response);
			/* 跳转 */
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
		InputStream is = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 上传大小
			factory.setSizeThreshold(1024 * 10240);

			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					// item.getInputStream() 获取上传文件的输入流
					is = item.getInputStream();
				} else {
					String paramName = item.getFieldName();
					String paramValue = item.getString();
					paramValue = new String(paramValue.getBytes("ISO-8859-1"), "UTF-8");
					params.put(paramName, paramValue);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

}
