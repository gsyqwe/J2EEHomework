package service;

import model.Order;

public interface OrderService {
    public boolean insert(String com,String num,String uid,Double money);

    public boolean check(String uid,Double money);
}
