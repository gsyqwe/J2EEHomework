package servlets;

import model.Commodity;
import model.CommodityClassfication;
import model.Order;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(urlPatterns = "/ShoppingServlet",loadOnStartup = 1)
public class ShoppingServlet extends HttpServlet {

    private Context ctx=null;
    private DataSource ods=null;
    private Connection con=null;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flag=request.getParameter("flag");
        if (flag.equals("buy")){
            buy(request,response);
        }else if (flag.equals("pick")){
            pick(request,response);
        }else if (flag.equals("check")){
            check(request,response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    //进行数据库的初始化等操作
    public void init(){
        try {
            ctx = new InitialContext();
            ods = (DataSource) ctx.lookup("java:comp/env/jdbc/j2ee");
            con = ods.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    //生成购买订单,完成购买操作
    public void buy(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        init();
        //检查能否购买
        String user=request.getParameter("user");
        double money=Double.parseDouble(request.getParameter("money"));
        Statement check=null;
        ResultSet res=null;
        try {
            check=con.createStatement();
            res=check.executeQuery("select * from user WHERE user.uaccount = '"+ user + "'");
            res.next();
            if (money<=res.getDouble("money")){
                //可以购买
                Date date=new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String oid=dateFormat.format(date);//得到订单号
                String coid=request.getParameter("commodity");//获取商品编号,在界面以分号隔开
                String conum=request.getParameter("commoditynumber");//获取商品数量,在界面以分号隔开
                int uid=res.getInt("uid");//得到userid
                Statement statement= null;
                try {
                    statement = con.createStatement();
                    statement.execute("INSERT INTO orders(oid,commodity,number,uid) VALUES ('"+ oid + "','" +
                            coid + "','" + conum + "','" + uid + "')");
                    statement.close();
                    con.close();
                    ctx.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
                response.getWriter().write("true");
                response.getWriter().close();
                request.getSession().setAttribute("buy","true");
                res.close();
                check.close();
            }else{
                //无法购买
                response.getWriter().write("false");
                response.getWriter().close();
                request.getSession().setAttribute("buy","false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("Buy.jsp").forward(request,response);
    }

    //生成商品的初始界面，得到商品的信息
    public void pick(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        init();
        ArrayList<CommodityClassfication> resultlist=new ArrayList<>();
        ArrayList<Commodity> resultlist1=new ArrayList<>();
        try {
            Statement statement=con.createStatement();
            ResultSet rs=null;
            rs=statement.executeQuery("select * from commodityclassfication");
            Statement statement1=con.createStatement();
            ResultSet rs1=null;
            rs1=statement1.executeQuery("SELECT * from commodity");
            resultlist=makeCommodityClassfication(rs);
            resultlist1=makeCommodity(rs1);
            rs1.close();
            rs.close();
            statement1.close();
            statement.close();
            con.close();
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("CommodityClassfication",resultlist);
        request.getSession().setAttribute("Commodity",resultlist1);
        request.getRequestDispatcher("Pick.jsp").forward(request, response);
    }

    //将得到的数据集包装成商品类别的ArrayList
    public ArrayList<CommodityClassfication> makeCommodityClassfication(ResultSet rs) throws SQLException {
        ArrayList<CommodityClassfication> commodityClassficationArrayList=new ArrayList<>();
        while(rs.next()){
            CommodityClassfication commodityClassfication=new CommodityClassfication();
            commodityClassfication.setCCid(rs.getInt("ccid"));//商品分类id
            commodityClassfication.setCCname(rs.getString("ccname"));//商品分类名称
            commodityClassficationArrayList.add(commodityClassfication);
        }
        return commodityClassficationArrayList;
    }

    //将得到的数据集包装成商品的ArrayList
    public ArrayList<Commodity> makeCommodity(ResultSet rs) throws SQLException {
        ArrayList<Commodity> commodityArrayList=new ArrayList<>();
        while(rs.next()){
            Commodity commodity=new Commodity();
            commodity.setCCid(rs.getInt("ccid"));//得到商品中商品分类id
            commodity.setCid(rs.getInt("cid"));//得到商品id
            commodity.setCname(rs.getString("cname"));//得到商品名
            commodity.setCprice(rs.getDouble("cprice"));//得到商品价格
            commodity.setCurl(rs.getString("curl"));//得到商品图片
            commodity.setInventory(rs.getInt("inventory"));//得到商品库存
            commodityArrayList.add(commodity);
        }
        return commodityArrayList;
    }

    //生成查看订单的操作
    public void check(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        init();
        String userid=request.getParameter("user");
        ArrayList<Order> orderArrayList=new ArrayList<>();
        try {
            ctx=new InitialContext();
            ods=(DataSource) ctx.lookup("java:comp/env/jdbc/j2ee");
            con=ods.getConnection();
            Statement statement=con.createStatement();
            ResultSet rs=null;
            rs=statement.executeQuery("SELECT *from orders WHERE orders.oid='" + userid + "'");
            orderArrayList=makeOrder(rs);
            rs.close();
            statement.close();
            con.close();
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("Orders",orderArrayList);
        request.getRequestDispatcher("Check.jsp").forward(request, response);
    }

    //将数据库中数据变成对应的订单
    public ArrayList<Order> makeOrder(ResultSet rs) throws SQLException {
        ArrayList<Order> orderArrayList=new ArrayList<>();
        while (rs.next()){
            Order order=new Order();
            order.setOid(rs.getString("oid"));//得到编号
            //得到商品的id,商品的以分号隔开
            String occom=rs.getString("ocom");
            String []ocid=occom.split(";");
            for (int i=0;i<ocid.length;i++){
                if (ocid[i].equals(";")){

                }else{
                    order.addCommodity(Integer.parseInt(ocid[i]));
                }
            }
            //得到商品的数量，商品的数量以分号隔开
            String ocnum=rs.getString("number");
            String []onum=ocnum.split(";");
            for (int i =0 ;i < onum.length; i ++){
                if (onum[i].equals(";")){

                }else{
                    order.addNum(Integer.parseInt(onum[i]));
                }
            }
            //得到商品的用户id
            order.setUid(rs.getInt("uid"));
            orderArrayList.add(order);
        }
        return orderArrayList;
    }
}
