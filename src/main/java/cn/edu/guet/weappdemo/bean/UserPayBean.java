package cn.edu.guet.weappdemo.bean;

import java.util.Objects;

public class UserPayBean {

    //商品id
    private String id;

    //商品价格
    private String price;

    //商品数量
    private int amount;

    //商品描述
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPayBean that = (UserPayBean) o;
        return amount == that.amount && id.equals(that.id) && price.equals(that.price) && body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, amount, body);
    }

    @Override
    public String toString() {
        return "UserPayBean{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", amount=" + amount +
                ", body='" + body + '\'' +
                '}';
    }
}
