package daoImpl;

import dao.CommodityDao;
import model.Commodity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class CommodityDaoImpl implements CommodityDao {

    private static CommodityDaoImpl commodityDao=new CommodityDaoImpl();

    private CommodityDaoImpl()
    {

    }

    public static CommodityDaoImpl getInstance()
    {
        return commodityDao;
    }

    @Override
    public List getallCommodity() {
        ArrayList<Commodity> commodityArrayList=new ArrayList();
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select c from Commodity C");
        commodityArrayList=(ArrayList<Commodity>)query.list();
        transaction.commit();
        session.close();
        return commodityArrayList;
    }
}
