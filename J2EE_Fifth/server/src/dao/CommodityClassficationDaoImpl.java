package dao;


import entity.CommodityclassficationEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CommodityClassficationDaoImpl implements CommodityClassficationDao{

    //得到全部的商品分类
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List findallCommodityClassfication() {
        ArrayList<CommodityclassficationEntity> list=new ArrayList();
        try
        {
            Query query=entityManager.createQuery("select c from CommodityclassficationEntity C");
            list=(ArrayList<CommodityclassficationEntity>)query.getResultList();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
