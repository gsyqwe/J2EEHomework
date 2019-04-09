package dao;

import entity.UserEntity;

import javax.ejb.Remote;
import java.util.List;
@Remote
public interface UserDao {
    public List Login();
    public void insert(UserEntity user);
    public UserEntity finduserByAccount(String uaccount);
}
