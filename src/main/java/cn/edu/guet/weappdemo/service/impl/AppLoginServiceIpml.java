package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.bean.AppUser;
import cn.edu.guet.weappdemo.mapper.AppLoginMapper;
import cn.edu.guet.weappdemo.service.AppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppLoginServiceIpml implements AppLoginService {

    @Autowired
    private AppLoginMapper appLoginMapper;

    @Override
    public List<AppUser> appLogin(String username, String password) {
        return appLoginMapper.appLogin(username, password);
    }

    @Override
    public int register(String username, String password) {
        System.out.println("打通服务层");
        System.out.println("？？？"+appLoginMapper.register(username, password));
        return 0;
    }

    @Override
    public void ImproveUserInformation(String phone,String username, String address, String sex) {
        System.out.println("打通服务层");
         appLoginMapper.ImproveUserInformation(phone,username,address,sex);
    }


}
