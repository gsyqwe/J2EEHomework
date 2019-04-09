package serviceImpl;

import Factory.DaoFactory;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private static UserServiceImpl userService;

    public UserServiceImpl(){

    }

    public static UserServiceImpl getInstance(){
        return userService;
    }

    public boolean login(String uaccount, String upassword) {
        boolean result=false;
        ArrayList<User>userArrayList=new ArrayList();
        userArrayList= (ArrayList<User>)DaoFactory.getUserDao().Login();
        for (int i=0;i<userArrayList.size();i++){
            if (uaccount.equals(userArrayList.get(i).getUaccount())){
               if (upassword.equals(userArrayList.get(i).getUpassword())){
                    result=true;
                }
            }
        }
        return result;
    }

    public void insert(String name,String pass,String account) {
        User user=new User();
        user.setUname(name);
        user.setUpassword(pass);
        user.setUaccount(account);
        user.setMoney(10000);
        DaoFactory.getUserDao().insert(user);
    }
}
