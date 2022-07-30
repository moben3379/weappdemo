package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.http.HttpResult;
import cn.edu.guet.weappdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("getOrderList")
    public HttpResult getOrderList() {

        return HttpResult.ok(orderService.orderList());
    }
}
