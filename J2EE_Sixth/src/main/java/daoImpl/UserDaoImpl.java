package daoImpl;
import dao.UserDao;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl userDao=new UserDaoImpl();

    private UserDaoImpl()
    {

    }

    public static UserDaoImpl getInstance()
    {
        return userDao;
    }

    @Override
    public List Login() {
        ArrayList<User> userArrayList=new ArrayList();
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select u from User U");
        userArrayList=(ArrayList<User>)query.list();
        transaction.commit();
        session.close();
        return userArrayList;
    }

    @Override
    public void insert(User user) {
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User finduserByAccount(String uaccount) {
        User user=new User();
        Session session=HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select * from user WHERE user.uaccount="+ "\"" + uaccount +"\"");
        user=(User)query.list().get(0);
        transaction.commit();
        session.close();
        return user;
    }

}
