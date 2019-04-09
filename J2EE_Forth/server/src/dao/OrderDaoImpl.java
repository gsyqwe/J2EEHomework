package dao;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateless
public class OrderDaoImpl implements OrderDao {

    private static DaoHelper daoHelper= DaoHelperImpl.getBaseDaoInstance();

    @Override
    public void insert(String oid,String commodity,String number,int uid) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try {
            stmt=con.prepareStatement("INSERT INTO orders(oid,commodity,number,uid) VALUES ('"+ oid + "','" +
                    commodity + "','" + number + "','" + uid + "')");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
        }
    }
}
