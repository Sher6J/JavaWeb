package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 设置编码
        req.setCharacterEncoding("utf-8");

        //2. 获取数据
        //2.1 获取用户填写的验证码
        String verifycode = req.getParameter("verifycode");
        //3. 校验验证码
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性

        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            //提示信息
            req.setAttribute("login_msg", "验证码错误");
            //跳转登录页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

            return;
        }

        Map<String, String[]> map = req.getParameterMap();
        //4. 封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



        //5. 调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);

        //6. 判断是否登录成功
        if (loginUser != null) {
            //登录成功
            //将用户存入session
            session.setAttribute("user", loginUser);
            //跳转页面
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            //登录失败
            //提示信息
            req.setAttribute("login_msg", "用户名或密码错误");
            //跳转登录页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}