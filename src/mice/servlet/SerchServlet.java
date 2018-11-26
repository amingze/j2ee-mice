package mice.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Product;

import mice.dao.ProductDAO;

public class SerchServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("serch");
        request.setCharacterEncoding("UTF-8");
        String serch = request.getParameter("ProductName");
        System.out.println("serch:" + serch);
        request.setAttribute("Productlist", ProductDAO.get(serch));
        for (Product bean : ProductDAO.get(serch)) {
            System.out.println(bean.getName());
        }
        request.getRequestDispatcher("/admin/admin_Product.jsp").forward(request, response);
    }
}