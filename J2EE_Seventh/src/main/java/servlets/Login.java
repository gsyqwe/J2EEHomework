package servlets;
/*
161250032 顾诗玉
作业：客户下订单应用 可在1个servlet中实现 客户登录：
未知的客户ID：错误页面
登录成功
从商品列表中选择商品提交，支付——根据具体情况，返回不同结果
正常结果：标准页面，下订单成功
有异常：下订单不成功
消费金额高：下订单成功，且有优惠
……
其他：商品列表分类、分页显示（选作） Servlet+Session+JDBC
 */
import Factory.ServiceFactory;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@RestController
@RequestMapping("/Login")
public class Login extends HttpServlet{

    @GetMapping("/login/{userpassword}/{useraccount}")
    public String login(@PathVariable("userpassword")String userpassword,
                      @PathVariable("useraccount")String useraccount){
        boolean result = ServiceFactory.getUserService().login(useraccount,userpassword);
        if (result==true){
            return "true";
        }
        return "false";
    }

    @GetMapping("/register/{username}/{useraccount}/{userpassword}")
    public void register(@PathVariable("username")String username,@PathVariable("useraccount")String useraccount,
                           @PathVariable("userpassowrd")String userpassword){
        ServiceFactory.getUserService().insert(username,userpassword,useraccount);
    }

}
