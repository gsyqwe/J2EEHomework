package servlets;

import Factory.ServiceFactory;
import model.Commodity;
import model.CommodityClassfication;
import model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/Shopping")
public class ShoppingServlet extends HttpServlet {

    @GetMapping("/addOrder/{user}/{money}/{commodity}/{commoditynumber}")
    public String addOrder(@PathVariable("user")String user,@PathVariable("money")double money,
                           @PathVariable("commodity")String commodity,@PathVariable("commoditynumber")String commoditynumber){
        boolean result=ServiceFactory.getOrderService().insert(commodity,commoditynumber,user,money);
        if (result==false){
            return "false";
        }
        return "true";
    }

}
