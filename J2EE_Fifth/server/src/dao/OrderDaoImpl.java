package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insert(String oid,String commodity,String number,int uid) {
        try {
            Query query=entityManager.createQuery("INSERT INTO orders(oid,commodity,number,uid) VALUES ('"+ oid + "','" +
                    commodity + "','" + number + "','" + uid + "')");
            query.executeUpdate();
            entityManager.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
