package cn.edu.guet.weappdemo.mapper;

import cn.edu.guet.weappdemo.bean.AppUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppLoginMapper {
    List<AppUser> appLogin(String wxnumber, String password);

    int register(String wxnumber, String password);

    void ImproveUserInformation(String phone,String username, String address, String sex);
}
