package dao;

import Util.JDBCUtil;
import entity.Notice;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
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

    //根据公文id删除公文
    public int delete(int i) {
        String deleteSQL="delete from notice where notice_id=?";
        try {
            JDBCUtil.queryRunner().update(deleteSQL, i);
            return  0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    //根据公文id更新公文
    public int update(Notice notice,int notice_id) {
        String updateSQL="UPDATE notice SET title=?,notice=?,department=? where notice_id=?";
        try {
            JDBCUtil.queryRunner().update(updateSQL, notice.getTitle(),notice.getNotice(),notice.getDepartment(),notice_id);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    //发布公文
    public int insert(Notice notice) {
        String insertSQL="insert into notice(title,notice,department) values(?,?,?);";
        try {
            JDBCUtil.queryRunner().update(insertSQL, notice.getTitle(),notice.getNotice(),notice.getDepartment());
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

}
