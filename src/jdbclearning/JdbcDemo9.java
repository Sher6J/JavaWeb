package jdbclearning;

import util.JdbcUtil;

import java.sql.*;
import java.util.Scanner;

/**
 * 需求：
 * 1. 通过键盘录入用户名和密码
 * 2. 判断用户是否登录成功
 */
public class JdbcDemo9 {
    public static void main(String[] args) {
        //1. 键盘录入，接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        //2. 调用方法
        boolean flag = new JdbcDemo9().isLogin2(username, password);

        //3. 判断结果, 输出不同语句
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码错误！");
        }

    }

    /**
     * 登录方法
     */
    public boolean isLogin(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //连接数据库判断是否登录成功

        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            //1. 获取数据库连接
            conn = JdbcUtil.getConnection();
            //2. 定义sql
            String sql = "select * from users where username = '" + username + "' and password = '" + password + "' ";
            //3. 获取执行sql的对象
            stmt = conn.createStatement();
            //4. 执行查询
            resultSet = stmt.executeQuery(sql);
            //5. 判断
            /*if (resultSet.next()) {
                return true;
            } else {
                return false;
            }*/
            //不要像上面那样写，太垃圾
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, stmt, conn);
        }
        return false;
    }

    /**
     * 登录方法, 使用PreparedStatement实现
     */
    public boolean isLogin2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //连接数据库判断是否登录成功

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            //1. 获取数据库连接
            conn = JdbcUtil.getConnection();
            //2. 定义sql
            String sql = "select * from users where username = ? and password = ?";
            //3. 获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            //给?赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            //4. 执行查询, 不需要传参
            resultSet = pstmt.executeQuery();
            //5. 判断
            /*if (resultSet.next()) {
                return true;
            } else {
                return false;
            }*/
            //不要像上面那样写，太垃圾
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, pstmt, conn);
        }
        return false;
    }
}
