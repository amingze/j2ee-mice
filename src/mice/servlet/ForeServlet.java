package mice.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Product;
import mice.bean.User;

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

        productDAO.get(id);
        return "product.jsp";
    }
}