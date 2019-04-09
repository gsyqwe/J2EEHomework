package dao;

import javax.ejb.Remote;

@Remote
public interface OrderDao {
    public void insert(String oid, String com, String num, int uid);
}
