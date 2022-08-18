package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.bean.LoginBean;
import cn.edu.guet.weappdemo.bean.SysUser;
import cn.edu.guet.weappdemo.http.HttpResult;
import cn.edu.guet.weappdemo.security.JwtAuthenticationToken;
import cn.edu.guet.weappdemo.service.AppLoginService;
import cn.edu.guet.weappdemo.service.SysUserService;
import cn.edu.guet.weappdemo.util.PasswordUtils;
import cn.edu.guet.weappdemo.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AppLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppLoginService appLoginService;

    @GetMapping("AppLogin")
    public HttpResult login(String username, String password, HttpServletRequest request) {
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        // 用户信息
        return HttpResult.ok(appLoginService.appLogin(username,password));
    }

    @GetMapping("AppRegister")
    public HttpResult register(String username, String password, HttpServletRequest request) {
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        appLoginService.register(username,password);
        // 用户信息
        return null;
    }

    @GetMapping("AppImproveUserInformation")
    public HttpResult ImproveUserInformation(String phone,String username, String address, String sex, HttpServletRequest request) {
        System.out.println("_________________________________修改层次___________________________________");
        System.out.println("用户电话："+phone);
        System.out.println("用户名："+username);
        System.out.println("密码："+address);
        System.out.println("密码："+sex);
        appLoginService.ImproveUserInformation(phone,username,address,sex);
        // 用户信息
        return null;
    }
}
