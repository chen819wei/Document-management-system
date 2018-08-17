package entity;

import lombok.Getter;
import lombok.Setter;

/*
* 管理员实体类
* */
@Setter@Getter
public class Administrator {
    //管理员账号
    private String user_name;
    //管理员密码
    private String user_password;

    @Override
    public String toString() {
        return "Administrator{" +
                "user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }

    public Administrator() {

    }

    public Administrator(String user_name, String user_password) {

        this.user_name = user_name;
        this.user_password = user_password;
    }
}
