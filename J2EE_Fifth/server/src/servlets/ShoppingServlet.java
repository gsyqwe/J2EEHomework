package servlets;

import Factory.EJBFactory;
import service.OrderService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ShoppingServlet",loadOnStartup = 1)
public class ShoppingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user=request.getParameter("user");
        Double money=Double.parseDouble(request.getParameter("money"));
        String commodity=request.getParameter("commodity");
        String number=request.getParameter("commoditynumber");
        OrderService orderService=(OrderService) EJBFactory.getEJB("ejb:/J2EE_Forth/OrderServiceImpl!service.OrderService");
        boolean result=orderService.insert(commodity,number,user,money);
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
