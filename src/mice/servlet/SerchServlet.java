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
        request.setCharacterEncoding("UTF-8");
        String serch = request.getParameter("goodsName");
        System.out.println("serch:"+serch);
        request.setAttribute("goodslist", GoodsDAO.get(serch));
        for (Goods bean : GoodsDAO.get(serch)) {
            System.out.println(bean.getName());
        }
        request.getRequestDispatcher("/admin/admin_goods.jsp").forward(request, response);
    }
}