package servlets;

import Factory.ServiceFactory;
import com.google.gson.JsonArray;
import model.Commodity;
import model.CommodityClassfication;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/Pick")
public class PickServlet extends HttpServlet{

    @GetMapping("/getCommodityClassfication")
    public JSONArray getCommodityClassfication(){
        ArrayList<CommodityClassfication> commodityClassficationArrayList= (ArrayList)ServiceFactory.getCommodityClassficationService().getallCommodityClassfication();
        JSONArray jsonArray=JSONArray.fromObject(commodityClassficationArrayList);
        return jsonArray;
    }

    @GetMapping("/getCommodity")
    public JSONArray getCommodity(){
        ArrayList<Commodity> commodityArrayList=(ArrayList)ServiceFactory.getCommodityService().findallCommodity();
        JSONArray jsonArray=JSONArray.fromObject(commodityArrayList);
        return jsonArray;
    }
}
