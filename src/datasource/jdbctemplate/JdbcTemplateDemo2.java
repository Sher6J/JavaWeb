package datasource.jdbctemplate;
/**
 * 数据库db3 emp表
 */

import domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import util.JdbcDruidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {

    //Junit单元测试, 可以让方法独立执行

    //1.获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JdbcDruidUtil.getDataSource());

    /**
     * 1. 修改1号数据的salary为10000
     */
    @Test
    public void test1() {
        //2.定义sql
        String sql = "update emp set salary = ? where id = ?";
        //3.执行sql
        int count = template.update(sql, 1000, 1001);
        System.out.println(count);
    }

    /**
     * 2. 添加一条记录
     */
    @Test
    public void test2() {
        //2.定义sql
        String sql = "insert into emp(id, ename, dept_id) values(?,?,?)";
        //3.执行sql
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    /**
     * 3. 删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    /**
     * 4.查询id为1002的记录, 将其封装为Map集合
     * 注意，这个方法查询的结果集只能是1
     */
    @Test
    public void test4() {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1002);
        System.out.println(map);
        //{id=1002, ename=卢俊义, job_id=3, mgr=1006, joindate=2001-02-20, salary=16000.00, bonus=3000.00, dept_id=30}
    }

    /**
     * 5.查询所有记录, 将其封装为List
     * 将每一条记录封装为一个Map集合, 再将Map集合装载到List集合中
     */
    @Test
    public void test5() {
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6.查询所有记录, 将其封装为Emp对象的List集合
     */
    @Test
    public void test6() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp(rs.getInt("id"), rs.getString("ename"),
                        rs.getInt("job_id"), rs.getInt("mgr"),
                        rs.getDate("joindate"), rs.getDouble("salary"),
                        rs.getDouble("bonus"), rs.getInt("dept_id"));


                return emp;
            }
        });

        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void test6_2() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 7.查询总记录数
     */
    @Test
    public void test7() {
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
