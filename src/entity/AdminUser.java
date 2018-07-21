package entity;

/*
*公文管理用户实体类
* */
public class AdminUser {
    //公文管理用户ID
    private int AdminUser_id;
    //公文管理用户名
    private String user_name;
    //公文管理用户密码
    private String user_password;
    //公文管理用户部门
    private String department;



    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
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

    public int getAdminUser_id() {
        return AdminUser_id;
    }

    public void setAdminUser_id(int adminUser_id) {
        AdminUser_id = adminUser_id;
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
