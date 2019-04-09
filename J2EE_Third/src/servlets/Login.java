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

@WebServlet(urlPatterns = "/Login",loadOnStartup = 1)
public class Login extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flag=request.getParameter("flag");//获取flag
        //进行session跟踪登录信息
        String login="";
        HttpSession session = request.getSession(false);
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        Integer ival = new Integer(1);

        ServletContext application = this.getServletContext();//取得application对象
        List<String> list = (List<String>) application.getAttribute("allUser");

        if (null != cookies) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("LoginCookie")) {
                    login=cookie.getValue();
                    break;
                }
            }
        }
        //进行操作
        boolean result = true;
        //调用登录方法
        if(flag.equals("login")){
            String name = request.getParameter("username");//获取账号
            String password = request.getParameter("userpassword");//获取密码
            login=name;
            result = ServiceFactory.getUserService().login(name,password);
        }else if(flag.equals("register")){
            String name = request.getParameter("user");
            String pass = request.getParameter("password");
            String account = request.getParameter("account");
            ServiceFactory.getUserService().insert(name,pass,account);
        }
        String res="";
        if(result==true){
            if(flag.equals("login")){
                //在登录成功时创建LoginCookie
                cookie = new Cookie("LoginCookie", login);
                cookie.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cookie);
                //创建session,表示此时处于登录状态
                session = request.getSession(true);
                session.setAttribute("login", login);
            }
            res="true";
        }else{
            res="false";
        }
        request.getSession().setAttribute("result",res);
        request.getSession().setAttribute("flag",flag);
        request.getSession().setAttribute("login",login);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
