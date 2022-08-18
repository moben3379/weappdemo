package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.bean.OrderList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    List<OrderList> orderList();

    int deleteOrderByOrderId(String orderId);

    List<OrderList> searchOrderList(String searchKey);/*查询订单*/

    int InsertOrder(String menu_id,String menu_name, String menu_quantity,String buyer_name, String buyer_phone, String buyer_address, String buyer_openid,Float order_amount);
}
