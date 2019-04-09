package dao;

import javax.ejb.Remote;
import java.util.List;
@Remote
public interface CommodityDao {
    public List getallCommodity();
}
