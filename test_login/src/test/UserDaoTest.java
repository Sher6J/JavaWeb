package test;

import dao.UserDao;
import domain.Users;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testlogin() {
        Users user = new Users();
        user.setUsername("superbaby");
        user.setPassword("13");

        UserDao dao = new UserDao();
        Users loginuser = dao.login(user);

        System.out.println(loginuser);
    }
}
