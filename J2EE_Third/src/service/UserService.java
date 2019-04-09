package service;

import model.User;

public interface UserService {
    public boolean login(String uaccount,String upassword);
    public void insert(String name,String pass,String account);
}
