package mice.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForeServlet extends ForeBaseServlet {

    public String home(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("homelist", productDAO.total());

        return "home.jsp";
    }
}