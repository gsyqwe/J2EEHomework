package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListeners implements ServletContextListener,HttpSessionListener,HttpSessionAttributeListener {

    private int onlinenum=0;//总的在线人数
    private int visitors=0;//游客人数

    ServletContext application = null;

    public void contextDestroyed(ServletContextEvent event) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        List<String> list = new ArrayList<String>();
        application =  event.getServletContext();
        application.setAttribute("allUser", list);
        application.setAttribute("visitors",visitors);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        //登录用户的人数+1
        List<String> list = (List<String>)application.getAttribute("allUser");
        //假设：用户登陆成功之后，只将户名设置到session中
        String userName = (String)httpSessionBindingEvent.getValue();
        //取得用户名
        if(list.indexOf(userName) == -1){
            //表示此用户之前没有登陆
            list.add(userName);
            application.setAttribute("allUser", list);
            visitors=onlinenum-list.size();
            application.setAttribute("visitor",visitors);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        List<String> list = (List<String>)application.getAttribute("allUser");
        list.remove((String)httpSessionBindingEvent.getValue());
        application.setAttribute("allUser", list);
        visitors=onlinenum-list.size();
        application.setAttribute("visitor",visitors);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //说明有人进入了网站，人数+1
        onlinenum++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }

}
