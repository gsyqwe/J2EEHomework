package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "j2ee", catalog = "")
public class UserEntity implements Serializable{
    private int uid;
    private String uname;
    private String upassword;
    private String uaccount;
    private Double money;

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "upassword")
    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    @Basic
    @Column(name = "uaccount")
    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    @Basic
    @Column(name = "money")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return uid == that.uid &&
                Objects.equals(uname, that.uname) &&
                Objects.equals(upassword, that.upassword) &&
                Objects.equals(uaccount, that.uaccount) &&
                Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, uname, upassword, uaccount, money);
    }
}
