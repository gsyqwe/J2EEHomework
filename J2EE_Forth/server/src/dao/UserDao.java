package dao;

import model.User;

import javax.ejb.Remote;
import java.util.List;
@Remote
public interface UserDao {
    public List Login();
    public void insert(User user);
    public User finduserByAccount(String uaccount);
}
