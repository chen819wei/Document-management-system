package dao;

import Util.JDBCUtil;
import entity.Department;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDao {
    //查看所有部门
    public List<Department> selectAll() {
        try {
            String selectSQL = "select * from Department";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanListHandler<Department>(Department.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //查看部门
    public Department select(int i) {
        try {
            String selectSQL = "select * from Department where department_id=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<Department>(Department.class),i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //添加部门
    public int insert(Department department) {
        try {
            String insertSQL = "INSERT INTO Department(department_name) values(?)";
            JDBCUtil.queryRunner().update(insertSQL, department.getDepartment_name());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

    }
    //删除部门
    public int delete(int i) {
        String deleteSQL = "delete from Department where department_id=?";
        try {
            JDBCUtil.queryRunner().update(deleteSQL, i);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }
    //根据id更新部门
    public int update(Department department, int department_id) {
        String updateSQL = "UPDATE Department SET department_name=? where department_id=?";
        try {
            JDBCUtil.queryRunner().update(updateSQL, department.getDepartment_name(),department_id);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }}
}
