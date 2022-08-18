package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.bean.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AppLoginService {
    List<AppUser> appLogin(String username, String password);

    int register(String username, String password);

    void ImproveUserInformation(String phone,String username, String address, String sex);
}
