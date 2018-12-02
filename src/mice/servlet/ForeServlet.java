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
        OrderItem orderItem = new OrderItem();
        User user = (User) request.getSession().getAttribute("user");
        orderItem.setUserId(user.getId());
        orderItem.setNumber(Integer.parseInt(request.getParameter("num")));
        orderItem.setStatus(2);
        orderItem.setProductId(Integer.parseInt(request.getParameter("productId")));
        OrderItemDAO.add(orderItem);
        return "!已加入购物车";
    }

    public String cart(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            List<OrderItem> beans = OrderItemDAO.getList(user.getId());

            request.setAttribute("cartlist", beans);
            return "cart.jsp";
        } else {
            return "@forehome";
        }
    }

    public String buy(HttpServletRequest request, HttpServletResponse response) {
        String pdIdList[] = request.getParameterValues("productId");
        String pdAmountList[] = request.getParameterValues("amoun");
        for (int i = 0; i < pdAmountList.length; i++) {
            System.out.println("!!pdAmountList!" + pdAmountList[i]);
        }

        float total = 0;
        int amount = 1;
        for (int i = 0; i < pdIdList.length; i++) {
            float product = productDAO.get(Integer.parseInt(pdIdList[i])).getPrice();
            amount = Integer.parseInt(pdAmountList[i]);
            total = total + product * amount;
        }
        request.setAttribute("total", total);
        System.out.println("!!total!" + total);
        return "accounts.jsp";
    }

    public String buyone(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter("productId");
        String productAmount = request.getParameter("productAmount");

        return "";

    }
    // public String category(HttpServletRequest request, HttpServletResponse
    // response){
    // int id=Integer.parseInt( request.getParameter("id"));
    // // Category beans= CategoryDAO.get(id);

    // return "category.jsp";
    // }
    // public String personal(HttpServletRequest request, HttpServletResponse
    // response){
    // User user =(User)request.getSession().getAttribute("user");
    // List<Order> beans= OrderDAO.getList(user.getId());
    // System.out.println("!!!cartlist!:"+beans);
    // for(Order bean:beans)
    // System.out.println("cartlist:"+bean.getProductId());
    // request.setAttribute("cartlist", beans);
    // return null;
    // }

}