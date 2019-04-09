package dao;

import model.Order;

public interface OrderDao {
    public void insert(String oid,String com,String num,int uid);
}
