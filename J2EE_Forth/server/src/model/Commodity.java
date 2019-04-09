package model;

import java.io.Serializable;

//商品
public class Commodity implements Serializable{
    private int cid;//商品编号，用于保存查找，自增
    private int ccid;//商品分类的编号，用来跟商品分类来进行对应
    private String cname;//商品名称
    private double cprice;//商品价格
    private String curl;//商品图片
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
