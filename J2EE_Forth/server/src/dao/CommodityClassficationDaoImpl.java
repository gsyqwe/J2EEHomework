package dao;

import model.CommodityClassfication;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CommodityClassficationDaoImpl implements CommodityClassficationDao{

    private static DaoHelper daoHelper= DaoHelperImpl.getBaseDaoInstance();

    //得到全部的商品分类
    @Override
    public List findallCommodityClassfication() {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        ArrayList<CommodityClassfication> list=new ArrayList();
        try
        {
            stmt=con.prepareStatement("select * from commodityclassfication");
            result=stmt.executeQuery();
            while(result.next())
            {
                CommodityClassfication commodityClassfication=new CommodityClassfication();
                commodityClassfication.setCCname(result.getString("ccname"));
                commodityClassfication.setCCid(result.getInt("ccid"));
                list.add(commodityClassfication);
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
        return list;
    }
}
