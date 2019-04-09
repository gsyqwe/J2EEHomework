package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "commodity", schema = "j2ee", catalog = "")
public class CommodityEntity implements Serializable{
    private int cid;
    private Integer ccid;
    private String cname;
    private Double cprice;
    private String curl;
    private Integer inventory;

    @Id
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "ccid")
    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    @Basic
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "cprice")
    public Double getCprice() {
        return cprice;
    }

    public void setCprice(Double cprice) {
        this.cprice = cprice;
    }

    @Basic
    @Column(name = "curl")
    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    @Basic
    @Column(name = "inventory")
    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityEntity that = (CommodityEntity) o;
        return cid == that.cid &&
                Objects.equals(ccid, that.ccid) &&
                Objects.equals(cname, that.cname) &&
                Objects.equals(cprice, that.cprice) &&
                Objects.equals(curl, that.curl) &&
                Objects.equals(inventory, that.inventory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cid, ccid, cname, cprice, curl, inventory);
    }
}
