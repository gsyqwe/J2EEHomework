package service;
import Factory.EJBFactory;
import dao.OrderDao;
import dao.UserDao;
import model.User;

import javax.ejb.Stateless;
import java.text.SimpleDateFormat;
import java.util.Date;

@Stateless
public class OrderServiceImpl implements OrderService {

    private int userid=0;

    @Override
    public boolean insert(String com,String num,String uid,Double money) {
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String oid=dateFormat.format(date);//得到订单号
        boolean check=check(uid,money);
        if (check==true){//可以购买
            OrderDao orderDao=(OrderDao) EJBFactory.getEJB("ejb:/J2EE_Forth/OrderDaoImpl!dao.OrderDao");
            orderDao.insert(oid,com,num,userid);
        }
        return check;
    }

    @Override
    public boolean check(String uid,Double money) {
        UserDao userDao=(UserDao)EJBFactory.getEJB("ejb:/J2EE_Forth/UserDaoImpl!dao.UserDao");
        User user=userDao.finduserByAccount(uid);
        if (user.getMoney()>=money){
            userid=user.getUid();
            return true;
        }
        return false;
    }


}
