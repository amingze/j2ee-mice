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

import mice.dao.AddressDAO;
import mice.dao.CategoryDAO;
import mice.dao.OrderDAO;
import mice.dao.OrderItemDAO;
import mice.dao.ProductDAO;
import mice.dao.ProductImageDAO;
import mice.dao.PropertyDAO;
import mice.dao.PropertyValueDAO;
import mice.dao.ReviewDAO;
import mice.dao.UserDAO;

public abstract class ForeBaseServlet<HttpservletRequest> extends HttpServlet {

    protected ProductDAO productDAO = new ProductDAO();
    protected UserDAO userDAO = new UserDAO();
    protected CategoryDAO categoryDAO = new CategoryDAO();
    protected AddressDAO addressDAO = new AddressDAO();
    protected OrderDAO orderDAO = new OrderDAO();
    protected OrderItemDAO orderItemDAO = new OrderItemDAO();
    protected ProductImageDAO productImageDAO = new ProductImageDAO();
    protected PropertyDAO propertyDAO = new PropertyDAO();
    // protected ProductItemDAO productItemDAO = new ProductItemDAO();
    protected PropertyValueDAO propertyValueDAO = new PropertyValueDAO();
    protected ReviewDAO reviewDAO = new ReviewDAO();

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String funtion = (String) request.getAttribute("funtion");
        System.out.println("fore funtion");
        try {
            System.out.println("funtion:" + funtion);
            Method fun = this.getClass().getMethod(funtion, javax.servlet.http.HttpServletRequest.class,
                    javax.servlet.http.HttpServletResponse.class);

            String invoke = fun.invoke(this, request, response).toString();
            System.out.println("!!!foreinvoke:" + invoke);
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

}