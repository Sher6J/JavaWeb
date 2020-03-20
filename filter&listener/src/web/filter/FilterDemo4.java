package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//@WebFilter("/index.jsp") //1.具体资源路径 /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
//@WebFilter("/user/*") //2.拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
//@WebFilter("*.jsp") //3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
public class FilterDemo4 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo4....");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
