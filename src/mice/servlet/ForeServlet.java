package mice.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mice.bean.Product;

public class ForeServlet extends ForeBaseServlet {

    public String home(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("productlist", productDAO.total());
        for(Product bean: productDAO.total())
            System.out.println("foreSeqvlet:"+bean.getName());
        return "home.jsp";
    }
    public String img(HttpServletRequest request, HttpServletResponse response){
        ProductServlet product=new ProductServlet();
        product.getimg(request, response);

        // productDAO.total()
        return null;
    }
}