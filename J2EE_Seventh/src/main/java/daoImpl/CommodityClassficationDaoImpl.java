package daoImpl;

import dao.CommodityClassficationDao;
import model.CommodityClassfication;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class CommodityClassficationDaoImpl implements CommodityClassficationDao{

    private static CommodityClassficationDaoImpl commodityClassficationDao=new CommodityClassficationDaoImpl();

    private CommodityClassficationDaoImpl()
    {

    }

    public static CommodityClassficationDaoImpl getInstance()
    {
        return commodityClassficationDao;
    }

    //得到全部的商品分类
    @Override
    public List findallCommodityClassfication() {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select c From CommodityClassfication C");
        ArrayList<CommodityClassfication> commodityClassficationArrayList=(ArrayList)query.list();
        transaction.commit();
        session.close();
        return commodityClassficationArrayList;
    }
}
