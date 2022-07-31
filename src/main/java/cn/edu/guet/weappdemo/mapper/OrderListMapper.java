package cn.edu.guet.weappdemo.mapper;

import cn.edu.guet.weappdemo.bean.OrderList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderListMapper {

    List<OrderList> getOrderList();

    int deleteOrderByOrderId(String orderId);

}
