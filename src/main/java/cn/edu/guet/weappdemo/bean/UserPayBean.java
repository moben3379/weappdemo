package cn.edu.guet.weappdemo.bean;

import java.util.Objects;

public class UserPayBean {

    //用户的openid
    private String openid;

    //商品描述
    private String body;

    //标价金额
    private int total_fee;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPayBean that = (UserPayBean) o;
        return total_fee == that.total_fee && openid.equals(that.openid) && body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openid, body, total_fee);
    }

    @Override
    public String toString() {
        return "UserPayBean{" +
                "openid='" + openid + '\'' +
                ", body='" + body + '\'' +
                ", total_fee=" + total_fee +
                '}';
    }

}
