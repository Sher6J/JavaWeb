package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//浏览器直接请求index.jsp资源时, 该过滤器会被执行
//那么浏览器通过访问ServletDemo2转发请求index.jsp时, 该过滤器就不会被执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)

//只有转发访问index.jsp资源时, 该过滤器才会被执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)

//转发和直接访问index.jsp资源时，该过滤器都会被执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo5...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
