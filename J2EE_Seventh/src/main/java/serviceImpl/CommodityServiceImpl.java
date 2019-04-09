package serviceImpl;

import Factory.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommodityService;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private static CommodityServiceImpl commodityService;

    public CommodityServiceImpl(){

    }

    public static CommodityServiceImpl getInstance(){
        return commodityService;
    }

    public List findallCommodity() {
        return DaoFactory.getCommoddityDao().getallCommodity();
    }
}
