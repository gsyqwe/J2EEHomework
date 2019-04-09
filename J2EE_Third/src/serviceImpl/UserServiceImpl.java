package serviceImpl;

import Factory.DaoFactory;
import model.User;
import service.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl userService=new UserServiceImpl();

    public UserServiceImpl(){

    }

    public static UserServiceImpl getInstance(){
        return userService;
    }

    @Override
    public boolean login(String uaccount, String upassword) {
        boolean result=false;
        ArrayList<User>userArrayList=new ArrayList<>();
        userArrayList= (ArrayList)DaoFactory.getUserDao().Login();
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
        User user=new User();
        user.setUname(name);
        user.setUpassword(pass);
        user.setUaccount(account);
        user.setMoney(10000);
        DaoFactory.getUserDao().insert(user);
    }
}
