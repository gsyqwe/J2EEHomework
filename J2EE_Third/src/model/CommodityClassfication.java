package model;

//商品分类
public class CommodityClassfication {
    private int ccid;//商品分类的id，设置自增
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
