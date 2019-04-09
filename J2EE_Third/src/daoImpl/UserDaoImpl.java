package daoImpl;

import dao.DaoHelper;
import dao.UserDao;
import model.CommodityClassfication;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl userDao=new UserDaoImpl();
    private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

    private UserDaoImpl()
    {

    }

    public static UserDaoImpl getInstance()
    {
        return userDao;
    }

    @Override
    public List Login() {
        ArrayList<User> userArrayList=new ArrayList<>();
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        try
        {
            stmt=con.prepareStatement("select * from user");
            result=stmt.executeQuery();
            while(result.next())
            {
                User user=new User();
                user.setMoney(result.getDouble("money"));
                user.setUaccount(result.getString("uaccount"));
                user.setUid(result.getInt("uid"));
                user.setUname(result.getString("uname"));
                user.setUpassword(result.getString("upassword"));
                userArrayList.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
            daoHelper.closeResult(result);
        }
        return userArrayList;
    }

    @Override
    public void insert(User user) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("insert into user (uname, upassword, uaccount,money) " +
                    "VALUES('" + user.getUname() + "','" + user.getUpassword() + "','" + user.getUaccount() +"','"
                    + user.getMoney()+ "')");
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
        }
    }

    @Override
    public User finduserByAccount(String uaccount) {
        User user=new User();
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        try
        {
            stmt=con.prepareStatement("select * from user WHERE user.uaccount="+ "\"" + uaccount +"\"");
            result=stmt.executeQuery();
            while(result.next())
            {
                user.setMoney(result.getDouble("money"));
                user.setUaccount(result.getString("uaccount"));
                user.setUid(result.getInt("uid"));
                user.setUname(result.getString("uname"));
                user.setUpassword(result.getString("upassword"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
            daoHelper.closeResult(result);
        }
        return user;
    }

}
