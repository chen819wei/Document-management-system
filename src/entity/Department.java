package entity;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Department {
    private int department_id;

    public Department(String department_name) {
        this.department_name = department_name;
    }

    public Department() {

    }

    private String department_name;
}
