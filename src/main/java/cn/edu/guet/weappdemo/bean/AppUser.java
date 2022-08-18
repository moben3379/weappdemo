package cn.edu.guet.weappdemo.bean;

import java.util.Objects;

public class AppUser {
    private int id;
    private String wxnumber;
    private String password;
    private String sex;
    private String address;
    private String phone;
    private String name;
    private String detail_address;
    private String other;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxnumber() {
        return wxnumber;
    }

    public void setWxnumber(String wxnumber) {
        this.wxnumber = wxnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id && Objects.equals(wxnumber, appUser.wxnumber) && Objects.equals(password, appUser.password) && Objects.equals(sex, appUser.sex) && Objects.equals(address, appUser.address) && Objects.equals(phone, appUser.phone) && Objects.equals(name, appUser.name) && Objects.equals(detail_address, appUser.detail_address) && Objects.equals(other, appUser.other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wxnumber, password, sex, address, phone, name, detail_address, other);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", wxnumber='" + wxnumber + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", detail_address='" + detail_address + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
