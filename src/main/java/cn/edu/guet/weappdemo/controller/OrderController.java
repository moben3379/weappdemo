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
        return HttpResult.ok(orderService.orderList());
    }

    @PostMapping("deleteOrderByOrderId")
    public HttpResult deleteOrderByOrderId(@RequestBody String orderId) {

        return HttpResult.ok(orderService.deleteOrderByOrderId(orderId));
    }

    @PostMapping("searchOrderList")
    /*测试测试测试*/
    public HttpResult searchOrderList(@RequestBody String searchKey){
        return HttpResult.ok(orderService.searchOrderList(searchKey));
    }

    @PostMapping("getPrepayId")
    public HttpResult getPrepayId(@RequestBody String prepayId){
        System.out.println(prepayId);
        return HttpResult.ok(prepayId);
    }

    @GetMapping("InsertOrder")
    public HttpResult InsertOrder( String menu_id, String menu_name, String menu_quantity, String buyer_name, String buyer_phone, String buyer_address, String buyer_openid, String order_amount){
        System.out.println(order_amount);
        Float totlePrice=Float.valueOf(order_amount);
        return HttpResult.ok(orderService.InsertOrder(menu_id,menu_name, menu_quantity,buyer_name, buyer_phone, buyer_address,buyer_openid, totlePrice));
    }
}
