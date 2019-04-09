package service;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CommodityClassficationService {
    public List getallCommodityClassfication();
}
