package serviceImpl;

import Factory.DaoFactory;
import model.Order;
import model.User;
import service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl orderService=new OrderServiceImpl();
    private int userid=0;

    public OrderServiceImpl() {

    }

    public static OrderServiceImpl getInstance(){
        return orderService;
    }

    @Override
    public boolean insert(String com,String num,String uid,Double money) {
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String oid=dateFormat.format(date);//得到订单号
        boolean check=check(uid,money);
        if (check==true){//可以购买
            DaoFactory.getOrderDao().insert(oid,com,num,userid);
        }
        return check;
    }

    @Override
    public boolean check(String uid,Double money) {
        User user=DaoFactory.getUserDao().finduserByAccount(uid);
        if (user.getMoney()>=money){
            userid=user.getUid();
            return true;
        }
        return false;
    }


}
