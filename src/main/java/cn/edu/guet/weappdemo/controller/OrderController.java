package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.http.HttpResult;
import cn.edu.guet.weappdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("getOrderList")
    public HttpResult getOrderList() {
        System.out.println("订单信息："+orderService.orderList());
        return HttpResult.ok(orderService.orderList());
    }

    @PostMapping("deleteOrderByOrderId")
    public HttpResult deleteOrderByOrderId(@RequestBody String orderId) {

        return HttpResult.ok(orderService.deleteOrderByOrderId(orderId));
    }

    @PostMapping("searchOrderList")
    /*测试测试测试*/
    public HttpResult searchOrderList(@RequestBody String searchKey){
        System.out.println(searchKey);
        return HttpResult.ok(orderService.searchOrderList(searchKey));
    }
}
