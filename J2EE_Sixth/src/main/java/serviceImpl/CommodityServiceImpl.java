package serviceImpl;

import Factory.DaoFactory;
import service.CommodityService;

import java.util.List;

public class CommodityServiceImpl implements CommodityService {

    private static CommodityServiceImpl commodityService=new CommodityServiceImpl();

    public CommodityServiceImpl(){

    }

    public static CommodityServiceImpl getInstance(){
        return commodityService;
    }

    @Override
    public List findallCommodity() {
        return DaoFactory.getCommoddityDao().getallCommodity();
    }
}
