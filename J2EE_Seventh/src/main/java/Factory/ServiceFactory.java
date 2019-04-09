package Factory;

import service.CommodityClassficationService;
import service.CommodityService;
import service.OrderService;
import service.UserService;
import serviceImpl.CommodityClassficationServiceImpl;
import serviceImpl.CommodityServiceImpl;
import serviceImpl.OrderServiceImpl;
import serviceImpl.UserServiceImpl;

public class ServiceFactory {
    public static UserService getUserService(){
        return UserServiceImpl.getInstance();
    }

    public static CommodityService getCommodityService(){
        return CommodityServiceImpl.getInstance();
    }

    public static CommodityClassficationService getCommodityClassficationService(){
        return CommodityClassficationServiceImpl.getInstance();
    }

    public static OrderService getOrderService(){
        return OrderServiceImpl.getInstance();
    }
}
