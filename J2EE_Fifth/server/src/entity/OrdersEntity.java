package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "j2ee", catalog = "")
public class OrdersEntity implements Serializable{
    private String oid;
    private String commodity;
    private String number;
    private Integer uid;

    @Id
    @Column(name = "oid")
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "commodity")
    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "uid")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return Objects.equals(oid, that.oid) &&
                Objects.equals(commodity, that.commodity) &&
                Objects.equals(number, that.number) &&
                Objects.equals(uid, that.uid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oid, commodity, number, uid);
    }
}
