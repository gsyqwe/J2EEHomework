package servlets;

import Factory.ServiceFactory;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user=request.getParameter("user");
        Double money=Double.parseDouble(request.getParameter("money"));
        String commodity=request.getParameter("commodity");
        String number=request.getParameter("commoditynumber");
        boolean result=ServiceFactory.getOrderService().insert(commodity,number,user,money);
        if (result==false){
            response.getWriter().write("false");
        }else{
            response.getWriter().write("true");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
