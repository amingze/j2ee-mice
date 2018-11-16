package mice.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Goods;
import mice.dao.GoodsDAO;

public class SerchServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("serch");
        String serch = (String) request.getAttribute("name");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("goodslist", GoodsDAO.get(serch));
        request.getRequestDispatcher("/admin/admin_goods.jsp").forward(request, response);
    }
}