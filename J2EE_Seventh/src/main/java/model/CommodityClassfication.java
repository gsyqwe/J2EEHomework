package model;

import javax.persistence.*;

//商品分类
@Entity
@Table(name="CommoddityClassfication")
public class CommodityClassfication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ccid;//商品分类的id，设置自增
    @Column
    private String ccname;//商品分类名称

    public CommodityClassfication(){
        ccid=0;
        ccname="";
    }

    public CommodityClassfication(int CCid, String CCname) {
        this.ccid = CCid;
        this.ccname = CCname;
    }

    public int getCCid() {
        return ccid;
    }

    public void setCCid(int CCid) {
        this.ccid = CCid;
    }

    public String getCCname() {
        return ccname;
    }

    public void setCCname(String CCname) {
        this.ccname = CCname;
    }
}
