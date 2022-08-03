package cn.edu.guet.weappdemo.mapper;

import cn.edu.guet.weappdemo.bean.OrderList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderListMapper {

    List<OrderList> getOrderList();

    List<OrderList> searchOrderList(String searchKey);/*查询订单*/

    int deleteOrderByOrderId(String orderId);

}
