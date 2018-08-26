package entity;

import lombok.*;

/*
*公文管理用户实体类
* */
@ToString
@NoArgsConstructor
public class AdminUser {
    //公文管理用户ID
    private int AdminUser_id;
    //公文管理用户名
    private String user_name;
    //公文管理用户密码
    private String user_password;
    //公文管理用户部门
    private String department;

    public int getAdminUser_id() {
        return AdminUser_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public String getUser_password() {
        return user_password;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public AdminUser(String user_name, String user_password, String department) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }
}
