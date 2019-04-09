package service;

import javax.ejb.Remote;

@Remote
public interface OrderService {
    public boolean insert(String com, String num, String uid, Double money);

    public boolean check(String uid, Double money);
}
