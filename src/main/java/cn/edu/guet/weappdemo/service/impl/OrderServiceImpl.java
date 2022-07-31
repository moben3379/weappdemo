package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.bean.OrderList;
import cn.edu.guet.weappdemo.mapper.OrderListMapper;
import cn.edu.guet.weappdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderListMapper orderListMapper;

    @Override
    public List<OrderList> orderList() {

        return orderListMapper.getOrderList();
    }
}
