package serviceImpl;

import Factory.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommodityClassficationService;
import java.util.List;

@Service
public class CommodityClassficationServiceImpl implements CommodityClassficationService {

    @Autowired
    private static CommodityClassficationServiceImpl commodityClassficationService;

    public CommodityClassficationServiceImpl(){

    }

    public static CommodityClassficationServiceImpl getInstance(){
        return commodityClassficationService;
    }


    public List getallCommodityClassfication() {
        return DaoFactory.getCommodityClassficationDao().findallCommodityClassfication();
    }
}
