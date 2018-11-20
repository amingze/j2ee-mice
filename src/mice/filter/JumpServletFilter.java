package mice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

public class JumpServletFilter implements Filter {

    @Override
    public void destroy() {
    }
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        request.setCharacterEncoding("UTF-8");

        String contextPath = request.getServletContext().getContextPath();
        request.setAttribute("contextPath", contextPath);
         
        String uri = request.getRequestURI();
        String url = StringUtils.remove(uri, contextPath);

        if (url.startsWith("/admin_")) {
            String servletPath = StringUtils.substringBetween(url, "_", "_");
            String funtion = StringUtils.substringAfterLast(url, "_");
            System.out.println("D");
            request.setAttribute("funtion", funtion);
            
            request.getRequestDispatcher("/"+servletPath + "Servlet").forward(request,response);
            return;
        }

       
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}