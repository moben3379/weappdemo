package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.bean.UserInfomationBean;

public interface WxChatService {
    int insertWxUser(String phone,String address,String open_id);

    UserInfomationBean findWxUserByOpenid(String openid);

    int updataUserInfo(String phone,String address,String open_id);
}
