package entity;

import lombok.Getter;
import lombok.Setter;

/*
 * 公文实体类
 * */
@Getter@Setter
public class Notice {
    //公文id
    private int notice_id;
    //公文标题
    private String title;
    //公文正文
    private String notice;
    //公文那些部门可见
    private String department;
    //公文发布时间
    private String release_time;
    //公文某人可以见
    private String people;


    public Notice(String title, String department, String notice) {
        this.title = title;
        this.notice = notice;
        this.department = department;
    }


    public Notice(String title, String notice, String department, String people) {
        this.title = title;
        this.notice = notice;
        this.department = department;
        this.people = people;

    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", title='" + title + '\'' +
                ", notice='" + notice + '\'' +
                ", department='" + department + '\'' +
                ", release_time='" + release_time + '\'' +
                ", people='" + people + '\'' +
                '}';
    }
}
