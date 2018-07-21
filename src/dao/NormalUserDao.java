package dao;

import Util.JDBCUtil;
import entity.NormalUser;
import org.apache.commons.dbutils.handlers.BeanHandler;
/*
* 普通用户数据库操作类
* */
public class NormalUserDao {
    //添加普通用户
    public int insert(NormalUser normal_user) {
        try {
            String insertSQL = "INSERT INTO NormalUser(user_name,user_password,department) values(?,?,?)";
            JDBCUtil.queryRunner().update(insertSQL, normal_user.getUser_name(), normal_user.getUser_password(),normal_user.getDepartment());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

    }
    //根据用户名查看用户信息
    public NormalUser select(String user_name) {
        try {
            String selectSQL = "select * from NormalUser where user_name=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<NormalUser>(NormalUser.class), user_name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
