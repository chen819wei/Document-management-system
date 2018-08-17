package entity;

import lombok.Getter;
import lombok.Setter;

/*
*公文管理用户实体类
* */
@Setter@Getter
public class AdminUser {
    //公文管理用户ID
    private int AdminUser_id;
    //公文管理用户名
    private String user_name;
    //公文管理用户密码
    private String user_password;
    //公文管理用户部门
    private String department;

    public AdminUser(String user_name, String user_password, String department) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }

    public AdminUser(int adminUser_id, String user_name, String user_password, String department) {
        AdminUser_id = adminUser_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }

    public AdminUser() {
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "AdminUser_id=" + AdminUser_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
