package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //对request对象请求消息增强
        System.out.println("filterDemo2...");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        //对response对象请求消息增强
        System.out.println("filterDemo2.......");
    }

    @Override
    public void destroy() {

    }
}
