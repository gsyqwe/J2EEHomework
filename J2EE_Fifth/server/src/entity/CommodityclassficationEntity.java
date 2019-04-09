package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "commodityclassfication", schema = "j2ee", catalog = "")
public class CommodityclassficationEntity implements Serializable{
    private int ccid;
    private String ccname;

    @Id
    @Column(name = "ccid")
    public int getCcid() {
        return ccid;
    }

    public void setCcid(int ccid) {
        this.ccid = ccid;
    }

    @Basic
    @Column(name = "ccname")
    public String getCcname() {
        return ccname;
    }

    public void setCcname(String ccname) {
        this.ccname = ccname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityclassficationEntity that = (CommodityclassficationEntity) o;
        return ccid == that.ccid &&
                Objects.equals(ccname, that.ccname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ccid, ccname);
    }
}
