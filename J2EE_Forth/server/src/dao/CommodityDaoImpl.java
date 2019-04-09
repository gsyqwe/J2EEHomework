package dao;

import model.Commodity;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CommodityDaoImpl implements CommodityDao {

    private static DaoHelper daoHelper= DaoHelperImpl.getBaseDaoInstance();

    @Override
    public List getallCommodity() {
        ArrayList<Commodity> commodityArrayList=new ArrayList<>();
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        try
        {
            stmt=con.prepareStatement("select * from commodity");
            result=stmt.executeQuery();
            while(result.next())
            {
                Commodity commodity=new Commodity();
                commodity.setCCid(result.getInt("ccid"));
                commodity.setCid(result.getInt("cid"));
                commodity.setCname(result.getString("cname"));
                commodity.setCprice(result.getDouble("cprice"));
                commodity.setCurl(result.getString("curl"));
                commodity.setInventory(result.getInt("inventory"));
                commodityArrayList.add(commodity);
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
        return commodityArrayList;
    }
}
