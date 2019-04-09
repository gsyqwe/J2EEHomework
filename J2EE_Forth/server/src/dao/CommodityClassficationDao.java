package dao;

import javax.ejb.Remote;
import java.util.List;
@Remote
public interface CommodityClassficationDao {
    public List findallCommodityClassfication();
}
