package filters;


import javax.servlet.*;
import java.io.IOException;

public class ShoppingFilter implements Filter {

    private String encoding="";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //设置字符集.
        request.setCharacterEncoding(encoding);
        //拿到链条继续向下调用.
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
