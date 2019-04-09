package dao;

import entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List Login() {
        ArrayList<UserEntity> userArrayList=new ArrayList<>();
        try
        {
            Query query=entityManager.createQuery("select u from UserEntity U");
            userArrayList=(ArrayList<UserEntity>)query.getResultList();
            entityManager.clear();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userArrayList;
    }

    @Override
    public void insert(UserEntity user) {
        try {
            Query query = entityManager.createQuery("insert into user (uname, upassword, uaccount,money) " +
                    "VALUES('" + user.getUname() + "','" + user.getUpassword() + "','" + user.getUaccount() + "','"
                    + user.getMoney() + "')");
            query.executeUpdate();
            entityManager.clear();
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public UserEntity finduserByAccount(String uaccount) {
        UserEntity user=new UserEntity();
        try
        {
            Query query=entityManager.createQuery("select u from UserEntity WHERE UserEntity u.uaccount="+ "\"" + uaccount +"\"");
            user=(UserEntity)query.getResultList();
            entityManager.clear();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

}
