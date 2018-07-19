package test;

import Util.JDBCUtil;
import dao.NormalUserDao;
import entity.NormalUser;
import org.junit.jupiter.api.Test;

public class NormalUserTest {
    @Test
    public void normalUserTest(){
        System.out.println(JDBCUtil.class.getClassLoader().getResource("db.properties").getPath());
        NormalUser normal_user = new NormalUser("zhang","chen","ºº ı≤ø");
        new NormalUserDao().insert(normal_user);
    }
}
