package service;

import Factory.EJBFactory;
import dao.CommodityDao;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CommodityServiceImpl implements CommodityService {

    @Override
    public List findallCommodity() {
        CommodityDao commodityDao=(CommodityDao) EJBFactory.getEJB("ejb:/J2EE_Forth/CommodityDaoImpl!dao.CommodityDao");
        return commodityDao.getallCommodity();
    }
}
