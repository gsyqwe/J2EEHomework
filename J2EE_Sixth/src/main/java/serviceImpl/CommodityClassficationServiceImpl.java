package serviceImpl;

import Factory.DaoFactory;
import service.CommodityClassficationService;

import java.util.List;

public class CommodityClassficationServiceImpl implements CommodityClassficationService {

    private static CommodityClassficationServiceImpl commodityClassficationService=new CommodityClassficationServiceImpl();

    public CommodityClassficationServiceImpl(){

    }

    public static CommodityClassficationServiceImpl getInstance(){
        return commodityClassficationService;
    }

    @Override
    public List getallCommodityClassfication() {
        return DaoFactory.getCommodityClassficationDao().findallCommodityClassfication();
    }
}
