package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.bean.UserInfomationBean;
import cn.edu.guet.weappdemo.http.HttpResult;
import cn.edu.guet.weappdemo.service.WxChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfomationController {

    @Autowired
    private WxChatService wxChatService;

    @PostMapping("/insertUserInfomation")
    public HttpResult insertUserInfomation(@RequestBody UserInfomationBean userInfomationBean){
        return HttpResult.ok(wxChatService.insertWxUser(userInfomationBean.getPhone(),userInfomationBean.getAddress(),userInfomationBean.getOpen_id()));
    }

    @GetMapping("findWxUserByOpenid")
    public HttpResult findWxUserByOpenid(String open_id){
        return HttpResult.ok(wxChatService.findWxUserByOpenid(open_id));
    }

    @PostMapping("/updataUserInfo")
    public HttpResult updataUserInfo(@RequestBody UserInfomationBean userInfomationBean){
        return HttpResult.ok(wxChatService.updataUserInfo(userInfomationBean.getPhone(),userInfomationBean.getAddress(),userInfomationBean.getOpen_id()));
    }
}
