/**



*/

package mice.servlet;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Order;
import mice.dao.OrderDAO;
<<<<<<< HEAD
=======
import mice.dao.OrderItemDAO;
import mice.service.OrderService;
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

public class OrderServlet extends BaseBackServlet {

	public String add(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

<<<<<<< HEAD
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	public String delivery(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Order o = orderDAO.get(id);
		o.setDeliveryDate(new Date());
		o.setStatus(OrderDAO.waitConfirm);
		orderDAO.update(o);
		return "@admin_order_list";
	}

	public String edit(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	public String update(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	public String list(HttpServletRequest request, HttpServletResponse response) {
		List<Order> os = orderDAO.list();
		orderItemDAO.fill(os);
		int total = orderDAO.getTotal();

		request.setAttribute("os", os);
=======
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
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

		return "admin/listOrder.jsp";
	}
}
