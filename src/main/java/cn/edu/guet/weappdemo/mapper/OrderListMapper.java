package cn.edu.guet.weappdemo.mapper;

import cn.edu.guet.weappdemo.bean.OrderList;
import cn.edu.guet.weappdemo.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderListMapper {

    List<OrderList> getOrderList();/*获取所有订单信息*/

    List<OrderList> searchOrderList(String searchKey);/*查询订单*/

    int deleteOrderByOrderId(String orderId);

    int InsertOrder(@Param("menu_id") String menu_id,@Param("menu_name") String menu_name,@Param("menu_quantity") String menu_quantity,@Param("buyer_name") String buyer_name,@Param("buyer_phone") String buyer_phone,@Param("buyer_address") String buyer_address,@Param("buyer_openid") String buyer_openid,@Param("order_amount") Float order_amount);

}
