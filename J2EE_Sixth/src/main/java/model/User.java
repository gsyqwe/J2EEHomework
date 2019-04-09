package model;

import javax.persistence.*;

//用户，用于登录
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;//用户id，进行自增
    @Column
    private String uname;//用户名称,用于显示
    @Column
    private String upassword;//密码
    @Column
    private String uaccount;//账号，用于登陆
    @Column
    private double money;//账号资金用于购买

    public User(){
        uid=0;
        uname="";
        upassword="";
        uaccount="";
        money=0;
    }

    public User(int uid,String uname,String upassword,String uaccount,double money){
        this.uid=uid;
        this.uname=uname;
        this.upassword=upassword;
        this.uaccount=uaccount;
        this.money=money;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
