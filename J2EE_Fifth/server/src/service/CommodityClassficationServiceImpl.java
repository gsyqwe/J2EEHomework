package service;
import Factory.EJBFactory;
import dao.CommodityClassficationDao;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CommodityClassficationServiceImpl implements CommodityClassficationService {

    @Override
    public List getallCommodityClassfication() {
        CommodityClassficationDao commodityClassficationDao = (CommodityClassficationDao) EJBFactory
                .getEJB("ejb:/J2EE_Forth/CommodityClassficationDaoImpl!dao.CommodityClassficationDao");
        return commodityClassficationDao.findallCommodityClassfication();
    }
}
