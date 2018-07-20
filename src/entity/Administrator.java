package entity;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Administrator {
    private String user_name;
    private String user_password;

    @Override
    public String toString() {
        return "Administrator{" +
                "user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
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

    public Administrator() {

    }

    public Administrator(String user_name, String user_password) {

        this.user_name = user_name;
        this.user_password = user_password;
    }
}
