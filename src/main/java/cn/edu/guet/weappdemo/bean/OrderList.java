package cn.edu.guet.weappdemo.bean;

import java.util.Date;

public class OrderList {
    private String order_id;

    private String menu_id;

    private String menu_price;

    private String menu_quantity;

    private String buyer_name;

    private String buyer_phone;

    private String buyer_address;

    private String buyer_openid;

    private String order_amount;

    private String order_status;

    private Date create_time;

    private Date update_time;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(String menu_price) {
        this.menu_price = menu_price;
    }

    public String getMenu_quantity() {
        return menu_quantity;
    }

    public void setMenu_quantity(String menu_quantity) {
        this.menu_quantity = menu_quantity;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyer_phone() {
        return buyer_phone;
    }

    public void setBuyer_phone(String buyer_phone) {
        this.buyer_phone = buyer_phone;
    }

    public String getBuyer_address() {
        return buyer_address;
    }

    public void setBuyer_address(String buyer_address) {
        this.buyer_address = buyer_address;
    }

    public String getBuyer_openid() {
        return buyer_openid;
    }

    public void setBuyer_openid(String buyer_openid) {
        this.buyer_openid = buyer_openid;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "order_id='" + order_id + '\'' +
                ", menu_id='" + menu_id + '\'' +
                ", menu_price='" + menu_price + '\'' +
                ", menu_quantity='" + menu_quantity + '\'' +
                ", buyer_name='" + buyer_name + '\'' +
                ", buyer_phone='" + buyer_phone + '\'' +
                ", buyer_address='" + buyer_address + '\'' +
                ", buyer_openid='" + buyer_openid + '\'' +
                ", order_amount='" + order_amount + '\'' +
                ", order_status='" + order_status + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
