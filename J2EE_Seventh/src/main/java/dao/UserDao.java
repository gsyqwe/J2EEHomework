package dao;

import model.User;
import java.util.List;

public interface UserDao {
    public List Login();
    public void insert(User user);
    public User finduserByAccount(String uaccount);
}
