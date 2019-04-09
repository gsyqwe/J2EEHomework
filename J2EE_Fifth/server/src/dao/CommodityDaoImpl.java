package dao;


import entity.CommodityEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CommodityDaoImpl implements CommodityDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List getallCommodity() {
        ArrayList<CommodityEntity> commodityArrayList=new ArrayList<>();
        try
        {
            Query query=entityManager.createQuery("select c from CommodityEntity C");
            commodityArrayList=(ArrayList<CommodityEntity>)query.getResultList();
            entityManager.clear();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return commodityArrayList;
    }
}
