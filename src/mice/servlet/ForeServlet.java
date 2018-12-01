package mice.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Order;
import mice.bean.Product;
import mice.bean.User;
import mice.dao.OrderDAO;

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
        Order order=new Order();
        User user=(User)request.getSession().getAttribute("user");
        System.out.println("!!addCart!UserID:"+user.getId());
        order.setUserId(user.getId());
        System.out.println("!!addCart!num:"+request.getParameter("num"));
        order.setNumber(Integer.parseInt(request.getParameter("num")));
        order.setStatus(2);
        System.out.println("!!addCart!productId:"+request.getParameter("productId"));
        order.setProductId(Integer.parseInt(request.getParameter("productId")));
        OrderDAO.add(order);
        // TO-DO OrderDAO.add(user,);
        return "!已加入购物车";
    }

    public String cart(HttpServletRequest request, HttpServletResponse response){
        User user=(User)request.getSession().getAttribute("user");
        OrderDAO.getList(user.getId());
        return "cart.jsp";
    }

    public String personal(HttpServletRequest request, HttpServletResponse response){

        return null;
    }
}