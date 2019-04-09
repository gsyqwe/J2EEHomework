package service;

import javax.ejb.Remote;

@Remote
public interface UserService {
    public boolean login(String uaccount, String upassword);
    public void insert(String name, String pass, String account);
}
