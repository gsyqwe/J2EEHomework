package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

//订单
@Entity
@Table(name="Orders")
public class Order {
    @Id
    private String oid;//订单号,使用日期+时间精确到秒方式进行生成
    private ArrayList<Integer> commodity;//商品的编号数组,用于处理一次购买很多商品时使用,在存储时使用String进行存储，使用;隔开不同的商品
    private ArrayList<Integer> number;//商品的数量,在生成数量插入时，使用;隔开每一个不同的数量
    @Column
    private int uid;//保存用户id

    @Column
    private String buycom;

    @Column
    private String num;

    public Order(){
        oid="";
        commodity=new ArrayList();
        number=new ArrayList();
        uid=0;
        buycom="";
        num="";
    }

    public Order(String oid, ArrayList<Integer> commodity, ArrayList<Integer> number, int uid,String buycom,String num) {
        this.oid = oid;
        this.commodity = commodity;
        this.number = number;
        this.uid = uid;
        this.buycom=buycom;
        this.num=num;
    }

    public void addCommodity(int commodity){
        this.commodity.add(commodity);
    }

    public void addNum(int num){
        this.number.add(num);
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public ArrayList<Integer> getCommodity() {
        return commodity;
    }

    public String getBuycom() {
        return buycom;
    }

    public void setBuycom(String buycom) {
        this.buycom = buycom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setCommodity(ArrayList<Integer> commodity) {
        this.commodity = commodity;
    }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<Integer> number) {
        this.number = number;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


}
