package cn.edu.guet.weappdemo.bean;

import java.util.Objects;

/**
 * @author jinyu
 * @date 2022/8/2 22:12
 */
public class UserBean {
    private Long id;
    private String name;
    private String nickName;
    private String email;
    private String mobile;
    private String password;
    private Long deptId;
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBean userBean = (UserBean) o;
        return id.equals(userBean.id) && name.equals(userBean.name) && nickName.equals(userBean.nickName) && email.equals(userBean.email) && mobile.equals(userBean.mobile) && password.equals(userBean.password) && deptId.equals(userBean.deptId) && roleId.equals(userBean.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickName, email, mobile, password, deptId, roleId);
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", deptId=" + deptId +
                ", roleId=" + roleId +
                '}';
    }
}
