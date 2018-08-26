package entity;

import lombok.*;

/*
 * 管理员实体类
 * */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    //管理员账号
    private String user_name;
    //管理员密码
    private String user_password;
}
