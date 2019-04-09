package model;

import javax.persistence.*;

//商品
@Entity
@Table(name="Commodity")
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;//商品编号，用于保存查找，自增
    @Column
    private int ccid;//商品分类的编号，用来跟商品分类来进行对应
    @Column
    private String cname;//商品名称
    @Column
    private double cprice;//商品价格
    @Column
    private String curl;//商品图片
    @Column
    private int inventory;//库存

    public Commodity() {
        cid=0;
        ccid=0;
        cname="";
        cprice=0;
        curl="";
        inventory=0;
    }

    public Commodity(int cid, int CCid, String cname, double cprice, String curl,int inventory) {
        this.cid = cid;
        this.ccid = CCid;
        this.cname = cname;
        this.cprice = cprice;
        this.curl = curl;
        this.inventory=inventory;
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCCid() {
        return ccid;
    }

    public void setCCid(int CCid) {
        this.ccid = CCid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
