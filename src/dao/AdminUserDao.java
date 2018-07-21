package dao;

import Util.JDBCUtil;
import entity.AdminUser;
import entity.NormalUser;
import org.apache.commons.dbutils.handlers.BeanHandler;

/*
* 公文管理用户数据库操作类
* */
public class AdminUserDao {
    //根据用户名查看用户信息
    public AdminUser select(String user_name) {
        try {
            String selectSQL = "select * from AdminUser where user_name=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<AdminUser>(AdminUser.class), user_name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
