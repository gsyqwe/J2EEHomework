package service;
import Factory.EJBFactory;
import dao.UserDao;
import entity.UserEntity;

import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String uaccount, String upassword) {
        boolean result=false;
        ArrayList<UserEntity>userArrayList=new ArrayList<>();
        UserDao userDao=(UserDao) EJBFactory.getEJB("ejb:/J2EE_Forth/UserDaoImpl!dao.UserDao");
        userArrayList= (ArrayList)userDao.Login();
        for (int i=0;i<userArrayList.size();i++){
            if (uaccount.equals(userArrayList.get(i).getUaccount())){
               if (upassword.equals(userArrayList.get(i).getUpassword())){
                    result=true;
                }
            }
        }
        return result;
    }

    @Override
    public void insert(String name,String pass,String account) {
        UserEntity user=new UserEntity();
        user.setUname(name);
        user.setUpassword(pass);
        user.setUaccount(account);
        user.setMoney((double)10000);
        UserDao userDao=(UserDao)EJBFactory.getEJB("ejb:/J2EE_Forth/UserDaoImpl!dao.UserDao");
        userDao.insert(user);
    }
}
