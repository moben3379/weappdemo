package cn.edu.guet.weappdemo.bean;

import java.util.Date;
import java.util.Objects;

public class UserInfomationBean {
    private int id;

    private String phone;

    private String address;

    private String open_id;

    private Date created_at;

    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfomationBean that = (UserInfomationBean) o;
        return id == that.id && phone.equals(that.phone) && address.equals(that.address) && open_id.equals(that.open_id) && created_at.equals(that.created_at) && updated_at.equals(that.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, address, open_id, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "UserInfomationBean{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", open_id='" + open_id + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
