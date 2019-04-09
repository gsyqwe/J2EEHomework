package daoImpl;
import dao.OrderDao;
import model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDaoImpl implements OrderDao {

    private static OrderDaoImpl orderDao=new OrderDaoImpl();

    private OrderDaoImpl()
    {

    }

    public static OrderDaoImpl getInstance()
    {
        return orderDao;
    }

    @Override
    public void insert(String oid,String commodity,String number,int uid) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Order order=new Order();
        order.setOid(oid);
        order.setUid(uid);
        order.setBuycom(commodity);
        order.setNum(number);
        session.save(order);
        transaction.commit();
        session.close();
    }
}
