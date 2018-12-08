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
        try {
            if (userDAO.isNoExist(bean.getName())) {
                userDAO.add(bean);
                request.setAttribute("status", "注册成功");
            } else {
                request.setAttribute("status", "名字已存在");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "register.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        User bean = userDAO.check(name, passwd);

        if (null == bean) {
            request.setAttribute("status", "erro");
            return "register.jsp";
        } else {
            request.getSession().setAttribute("user", bean);
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

        Product product = productDAO.get(id);
        request.setAttribute("productId", product.getId());
        request.setAttribute("name", product.getName());
        request.setAttribute("price", product.getPrice());
        return "product.jsp";
    }

    public String addCart(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        String id = request.getParameter("pid");
        String num = request.getParameter("num");

        int pid = Integer.parseInt(id);
        int amount = Integer.parseInt(num);
        if (NumCheck.IsNoPositive(amount))
            return "!";

        OrderItem orderItem = new OrderItem();

        if (orderItemDAO.isNoExistCartByPId(pid)) {
            orderItem.setUserId(user.getId());
            orderItem.setProductId(pid);
            orderItem.setAmount(amount);
            orderItem.setStatus(2);
            orderItemDAO.add(orderItem);
        } else {
            orderItem = orderItemDAO.getByPId(pid);
            orderItem.setAmount(orderItemDAO.get(orderItem.getId()).getAmount() + amount);
            orderItemDAO.updata(orderItem);
        }
        return "!";
    }

    public String cart(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            List<OrderItem> beans = orderItemDAO.getCart(user.getId());

            request.setAttribute("cartlist", beans);
            return "cart.jsp";
        } else {
            return "@forehome";
        }
    }

    public String deleteCart(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        String id = request.getParameter("oiid");
        int pid = Integer.parseInt(id);

        if (orderItemDAO.isExistCartByOIId(pid)) {
            orderItemDAO.delete(pid);
        }
        return "!";
    }

    public String addAmount(HttpServletRequest request, HttpServletResponse response) {
        String oiId = request.getParameter("orderItemId");
        int id = Integer.parseInt(oiId);
        if (orderItemDAO.get(id).getAmount() > 1)
            orderItemDAO.changeAmount(id, orderItemDAO.get(id).getAmount() + 1);
        return "!";
    }

    public String reduceAmount(HttpServletRequest request, HttpServletResponse response) {
        String oiId = request.getParameter("orderItemId");
        int id = Integer.parseInt(oiId);
        if (orderItemDAO.get(id).getAmount() > 1)
            orderItemDAO.changeAmount(id, orderItemDAO.get(id).getAmount() - 1);
        return "!";
    }

    public String changeAmount(HttpServletRequest request, HttpServletResponse response) {
        String oiAmount = request.getParameter("orderItemAmount");
        String oiId = request.getParameter("orderItemId");
        int orderItemAmount = Integer.parseInt(oiAmount);
        int orderItemId = Integer.parseInt(oiId);
        if (orderItemAmount > 0)
            orderItemDAO.changeAmount(orderItemId, orderItemAmount);
        return "!";
    }

    public String buy(HttpServletRequest request, HttpServletResponse response) {
        String paramsList[] = request.getParameterValues("oiid");
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
            orderItemDAO.changeStatus(orderItemId, 3);// 更改状态为未支付

            total += orderItem.getAmount() * orderItem.getProduct().getPrice();
        }
        System.out.println("!!!total!" + total);
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
        orderItemDAO.changeStatus(oid, 4);
        return "over.jsp";
    }

    public String showOrder(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<List<OrderItem>> orders = orderDAO.getByUser(user.getId());
        request.setAttribute("orders", orders);
        return "order.jsp";
    }

}