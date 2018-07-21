package dao;

import Util.JDBCUtil;
import entity.NormalUser;
import entity.Notice;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;
/*
* 公文数据库操作
* */
public class NoticeDao {
    //根据部门查看公文
    public List<Notice> selectAll(String department) {
        try {
            String selectSQL = "select * from notice where department=? or department=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanListHandler<Notice>(Notice.class),department,"全部部门");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据公文id查看公文详情
    public Notice select(int i) {
        try {
            String selectSQL = "select * from notice where notice_id=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<Notice>(Notice.class), i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
