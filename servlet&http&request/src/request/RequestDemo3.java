package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头数据:user-agent

        String agent = req.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")){
            //谷歌
            System.out.println("谷歌来了");
        } else if (agent.contains("Firefox")) {
            //火狐
            System.out.println("火狐来了");
        }
    }
}
