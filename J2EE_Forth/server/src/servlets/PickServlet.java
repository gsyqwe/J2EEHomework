package servlets;

import Factory.EJBFactory;
import model.Commodity;
import model.CommodityClassfication;
import net.sf.json.JSONArray;
import service.CommodityClassficationService;
import service.CommodityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/PickServlet",loadOnStartup = 1)
public class PickServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flag=request.getParameter("flag");
        JSONArray result=new JSONArray();
        if (flag.equals("classfication")){
            result=getCommodityClassfication();
        }else if (flag.equals("commodity")){
            result=getCommodity();
        }
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(result);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public JSONArray getCommodityClassfication(){
        CommodityClassficationService commodityClassficationService=(CommodityClassficationService) EJBFactory.getEJB("ejb:/J2EE_Forth/CommodityClassficationServiceImpl!service.CommodityClassficationService");
        ArrayList<CommodityClassfication> commodityClassficationArrayList= (ArrayList)commodityClassficationService.getallCommodityClassfication();
        JSONArray jsonArray=JSONArray.fromObject(commodityClassficationArrayList);
        return jsonArray;
    }

    public JSONArray getCommodity(){
        CommodityService commodityService=(CommodityService) EJBFactory.getEJB("ejb:/J2EE_Forth/CommodityServiceImpl!service.CommodityService");
        ArrayList<Commodity> commodityArrayList=(ArrayList)commodityService.findallCommodity();
        JSONArray jsonArray=JSONArray.fromObject(commodityArrayList);
        return jsonArray;
    }
}
