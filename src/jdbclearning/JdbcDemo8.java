package jdbclearning;

import domain.Emp;
import util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */
public class JdbcDemo8 {
    public static void main(String[] args) {
//        List<Emp> list = new JdbcDemo8().findAll();
        List<Emp> list = new JdbcDemo8().findAll2();
        System.out.println(list);
        System.out.println(list.size());
    }
    /**
     * 查询所有emp对象
     * @return
     */
    public List<Emp> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        List<Emp> list = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            //3. 定义sql
            String sql = "select * from emp";
            //4. 获取执行sql语句对象Statement
            stmt = conn.createStatement();
            //5. 执行sql
            resultSet = stmt.executeQuery(sql);
            //6. 遍历结果集, 封装对象, 装在集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (resultSet.next()) {
                //获取数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                //创建emp对象
                emp = new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 演示JDBC工具类
     * @return
     */
    public List<Emp> findAll2() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        List<Emp> list = null;
        try {
            /*//1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");*/
            conn = JdbcUtil.getConnection();
            //3. 定义sql
            String sql = "select * from emp";
            //4. 获取执行sql语句对象Statement
            stmt = conn.createStatement();
            //5. 执行sql
            resultSet = stmt.executeQuery(sql);
            //6. 遍历结果集, 封装对象, 装在集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (resultSet.next()) {
                //获取数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                //创建emp对象
                emp = new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, stmt, conn);
        }
        return list;
    }
}
