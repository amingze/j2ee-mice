package mice.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import mice.dao.ProductDAO;

public abstract class BackBaseServlet<HttpservletRequest> extends HttpServlet {
	public abstract String add(HttpServletRequest request, HttpServletResponse reques);

	protected ProductDAO ProductDao = new ProductDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funtion = (String) request.getAttribute("funtion");
		try {
			System.out.println("funtion:" + funtion);
			Method fun = this.getClass().getMethod(funtion, javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class);
			String invoke = fun.invoke(this, request, response).toString();

			if (invoke.startsWith("@")) {
				response.sendRedirect(invoke.substring(1));
			} else if (invoke.startsWith("!")) {

			} else {
				request.getRequestDispatcher(invoke).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	protected InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
		InputStream is = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			factory.setSizeThreshold(1024 * 1024 * 10);
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (!iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					is = item.getInputStream();
				} else {
					String paramName = item.getFieldName();
					String paramValue = item.getString();
					paramValue = new String(paramValue.getBytes("GBK"), "UTF-8");
					params.put(paramName, paramValue);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

}