package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo7 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo7...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filterDemo7......");
    }

    @Override
    public void destroy() {

    }
}
