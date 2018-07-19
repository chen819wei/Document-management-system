package test;

import Util.JDBCUtil;
import dao.NormalUserDao;
import entity.NormalUser;
import org.junit.jupiter.api.Test;

public class NormalUserTest {
    @Test
    public void normalUserTest(){
        System.out.println(JDBCUtil.class.getClassLoader().getResource("db.properties").getPath());
        NormalUser normalUser=new NormalUserDao().select("chen");
        System.out.println(normalUser.getDepartment());
        System.out.println(normalUser.getUser_password().equals("chen"));
        System.out.println(normalUser.getUser_name());
        System.out.println(normalUser);

    }
}
