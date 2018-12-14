package mice.servlet;

import java.sql.SQLException;
import java.util.ArrayList;
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
import mice.service.ProductService;
import mice.service.UserService;
import mice.util.NumCheck;

public class ForeServlet extends ForeBaseServlet {

    public String home(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("productlist", productDAO.total());
        for (Product bean : productDAO.total())
            System.out.println("foreSeqvlet:" + bean.getName());
        return "home.jsp";
    }

    public String register(HttpServletRequest request, HttpServletResponse response) {
        User bean = new User();
        bean.setName(request.getParameter("name"));
        bean.setPasswd(request.getParameter("passwd"));
        if (UserService.register(bean)) {
            request.setAttribute("registerStatus", "注册成功");
        } else {
            request.setAttribute("registerStatus", "注册失败");
        }
        return "register.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) {
        User userBean = UserService.login(request.getParameter("name"), request.getParameter("passwd"));
        if (null == userBean) {
            request.setAttribute("status", "登录失败");
            return "login.jsp";
        } else {
            request.getSession().setAttribute("userBean", userBean);
            return "@forehome";
        }
    }

    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        return "@forehome";
    }

    public String img(HttpServletRequest request, HttpServletResponse response) {
        ProductServlet product = new ProductServlet();
        product.getimg(request, response);
        return "!";
    }

    public String product(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product productBean = ProductService.getProduct(id);
        request.setAttribute("productBean", productBean);
        return "product.jsp";
    }

    public String addCart(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        String pid = request.getParameter("pid");
        String num = request.getParameter("num");
        OrderService.addCart(pid, user.getId(), num);
        return "!";
    }

    public String cart(HttpServletRequest request, HttpServletResponse response) {
        User userBean = (User) request.getSession().getAttribute("user");
        if (userBean != null) {
            List<OrderItem> beans = OrderService.getCartList(userBean);
            request.setAttribute("cartList", beans);
            return "cart.jsp";
        } else {
            return "@forehome";
        }
    }

    public String deleteCart(HttpServletRequest request, HttpServletResponse response) {
        User userBean = (User) request.getSession().getAttribute("userBean");
        String oiId = request.getParameter("oiId");
        if (!UserService.isLogin(userBean)) {
            return "@forehome";
        }
        OrderService.deleteCart(oiId);
        return "!";
    }

    public String addAmount(HttpServletRequest request, HttpServletResponse response) {
        String oiId = request.getParameter("orderItemId");
        OrderService.addAmount(oiId);
        return "!";
    }

    public String reduceAmount(HttpServletRequest request, HttpServletResponse response) {
        String oiId = request.getParameter("orderItemId");
        OrderService.reduceAmount(oiId);
        return "!";
    }

    public String changeAmount(HttpServletRequest request, HttpServletResponse response) {
        String oiAmount = request.getParameter("orderItemAmount");
        String oiId = request.getParameter("orderItemId");
        OrderService.changeAmount(oiId, oiAmount);
        return "!";
    }

    public String buy(HttpServletRequest request, HttpServletResponse response) {
        String paramsList[] = request.getParameterValues("oiId");
        User user = (User) request.getSession().getAttribute("user");
        // List<OrderItem> order=new ArrayList<>();
        float total = 0;

        int oid = orderDAO.createOrder();
        Order bean = new Order();
        bean.setId(oid);
        bean.setUserId(user.getId());
        orderDAO.updata(bean);

        for (String strid : paramsList) {
            int orderItemId = Integer.parseInt(strid);
            OrderItem orderItem = orderItemDAO.get(orderItemId);

            // order.add(orderItem);
            // updata
            orderItemDAO.setOrder(orderItemId, oid);
            orderItemDAO.changeStatus(orderItemId, OrderDAO.waitPay);// 更改状态为未支付

            total += orderItem.getNumber() * orderItem.getProduct().getPrice();
        }
        request.getSession().setAttribute("oid", oid);
        request.getSession().setAttribute("total", total);
        return "pay.jsp";
    }

    public String buyone(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter("productId");
        String productAmount = request.getParameter("orderItemAmount");

        return "";

    }

    public String pay(HttpServletRequest request, HttpServletResponse response) {
        float orderPriceTotal = (float) request.getSession().getAttribute("total");
        int oid = (int) request.getSession().getAttribute("oid");
        orderItemDAO.changeStatus(oid, orderDAO.waitDelivery);
        return "over.jsp";
    }

    public String showOrder(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<List<OrderItem>> orders = orderDAO.getByUser(user.getId());
        request.setAttribute("orders", orders);
        return "order.jsp";
    }

}