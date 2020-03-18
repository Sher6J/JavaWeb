package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post获取请求参数

        //根据参数名称获取参数值
        String username = req.getParameter("username");
        /*System.out.println("post:");
        System.out.println(username);*/

        //根据参数获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        /*for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        //获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        /*while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = req.getParameter(name);
            System.out.println(value);
            System.out.println("--------");
        }*/

        //获取所有参数的Map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历
        Set<String> keys = parameterMap.keySet();
        for (String name : keys) {
            //根据键获取值
            String[] values = parameterMap.get(name);
            for (String value :  values) {
                System.out.println(value);
            }

            System.out.println("------");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get获取请求参数

        /*//根据参数名称获取参数值
        String username = req.getParameter("username");
        System.out.println("get:");
        System.out.println(username);*/

        this.doPost(req, resp);
    }
}
