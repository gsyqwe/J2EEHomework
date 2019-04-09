package servlets;

import Factory.ServiceFactory;
import com.google.gson.JsonArray;
import model.Commodity;
import model.CommodityClassfication;
import net.sf.json.JSONArray;

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
        ArrayList<CommodityClassfication> commodityClassficationArrayList= (ArrayList)ServiceFactory.getCommodityClassficationService().getallCommodityClassfication();
        JSONArray jsonArray=JSONArray.fromObject(commodityClassficationArrayList);
        return jsonArray;
    }

    public JSONArray getCommodity(){
        ArrayList<Commodity> commodityArrayList=(ArrayList)ServiceFactory.getCommodityService().findallCommodity();
        JSONArray jsonArray=JSONArray.fromObject(commodityArrayList);
        return jsonArray;
    }
}
