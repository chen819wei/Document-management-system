package entity;

/*
 * 普通用户实体类
 * */
public class NormalUser {
    //用户ID
    private int user_id;
    //用户名
    private String user_name;
    //用户密码
    private String user_password;
    //所属部门
    private String department;


    public NormalUser() {
    }

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public NormalUser(int user_id, String user_name, String user_password, String department) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }

    @Override
    public String toString() {
        return "NormalUser{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
