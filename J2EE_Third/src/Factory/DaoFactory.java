package Factory;

import dao.CommodityClassficationDao;
import dao.CommodityDao;
import dao.OrderDao;
import dao.UserDao;
import daoImpl.CommodityClassficationDaoImpl;
import daoImpl.CommodityDaoImpl;
import daoImpl.OrderDaoImpl;
import daoImpl.UserDaoImpl;

public class DaoFactory {
    public static CommodityClassficationDao getCommodityClassficationDao()
    {
        return CommodityClassficationDaoImpl.getInstance();
    }

    public static CommodityDao getCommoddityDao(){
        return CommodityDaoImpl.getInstance();
    }

    public static OrderDao getOrderDao(){
        return OrderDaoImpl.getInstance();
    }

    public static UserDao getUserDao(){
        return UserDaoImpl.getInstance();
    }
}
