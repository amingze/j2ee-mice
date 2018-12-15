package mice.servlet;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Order;
import mice.bean.OrderItem;
import mice.bean.Product;
import mice.bean.User;
import mice.dao.OrderDAO;
import mice.dao.OrderItemDAO;
import mice.service.OrderService;

public class OrderServlet extends ForeBaseServlet {

    public static String list(HttpServletRequest request, HttpServletResponse response) {
        List<List<OrderItem>> orderList = OrderService.list();
        request.setAttribute("orderList", orderList);
        return "!";
    }

    public String changeStatus(HttpServletRequest request, HttpServletResponse response) {
        String orderId = request.getParameter("orderId");
        String orderStatus = request.getParameter("orderStatus");
        int int_orderId = Integer.parseInt(orderId);
        OrderService.status(int_orderId, orderStatus);
        return "!";
    }

}