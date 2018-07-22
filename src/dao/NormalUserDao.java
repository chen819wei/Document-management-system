package dao;

import Util.JDBCUtil;
import entity.NormalUser;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
 * 普通用户数据库操作类
 * */
public class NormalUserDao {
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
    //添加普通用户
    public int insert(NormalUser normal_user) {
        try {
            String insertSQL = "INSERT INTO NormalUser(user_name,user_password,department) values(?,?,?)";
            JDBCUtil.queryRunner().update(insertSQL, normal_user.getUser_name(), normal_user.getUser_password(), normal_user.getDepartment());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

    }


    //根据用户id查看用户信息
    public NormalUser select(int user_id) {
        try {
            String selectSQL = "select * from NormalUser where user_id=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<NormalUser>(NormalUser.class), user_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //查看所有用户
    public List<NormalUser> selectAll() {
        try {
            String selectSQL = "select * from NormalUser";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanListHandler<NormalUser>(NormalUser.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据id删除用户
    public int delete(int i) {
        String deleteSQL = "delete from NormalUser where user_id=?";
        try {
            JDBCUtil.queryRunner().update(deleteSQL, i);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    //根据id更新用户信息
    public int update(NormalUser normalUser, int user_id) {
        String updateSQL = "UPDATE NormalUser SET user_name=?,user_password=?,department=? where user_id=?";
        try {
            JDBCUtil.queryRunner().update(updateSQL, normalUser.getUser_name(), normalUser.getUser_password(), normalUser.getDepartment(), user_id);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }
}
